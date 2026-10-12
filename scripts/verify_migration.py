"""Verify migration provenance and current files using local Git objects."""
import hashlib
import json
import subprocess
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]

def git(*args):
    return subprocess.check_output(["git", "-C", str(ROOT), *args])

def require(condition, message):
    if not condition:
        raise SystemExit(message)

def main():
    manifest = json.loads((ROOT / "docs/migration-manifest.json").read_text(encoding="utf-8"))
    entries = manifest["files"]
    require(len(entries) == 57, "Unexpected original file count")
    for source in manifest["sources"]:
        commits = git("rev-list", source["tip"]).decode().splitlines()
        require(commits == source["commits"], "Original commit graph changed")
        for commit in commits:
            subprocess.run(["git", "-C", str(ROOT), "merge-base", "--is-ancestor", commit, "HEAD"], check=True)
        paths = git("ls-tree", "-r", "--name-only", source["tip"]).decode().splitlines()
        recorded = [f["source_path"] for f in entries if f["game"] == source["game"]]
        require(sorted(paths) == sorted(recorded), "Source file mapping is incomplete")
    counts = {"unchanged": 0, "modified": 0, "excluded": 0}
    for entry in entries:
        source_blob = git("rev-parse", entry["source_commit"] + ":" + entry["source_path"]).decode().strip()
        require(source_blob == entry["source_blob"], "Original blob mismatch")
        require(hashlib.sha256(git("cat-file", "blob", source_blob)).hexdigest() == entry["source_sha256"], "Original SHA-256 mismatch")
        target = ROOT / entry["destination_path"]
        status = entry["status"]
        if status == "excluded":
            require(not target.exists(), "Excluded file present: " + str(target))
        else:
            require(target.is_file(), "Missing destination: " + str(target))
            actual = git("hash-object", "--path=" + entry["destination_path"], str(target)).decode().strip()
            require(actual == entry["destination_blob"], "Destination changed: " + str(target))
            if status == "unchanged":
                require(actual == source_blob, "Unchanged source differs")
            else:
                require(entry["destination_path"] == "FlappyBird/src/FlappyBird.java", "Unexpected source modification")
        counts[status] += 1
    print("PASS: all 6 original commits preserved; all 57 original files accounted for")
    print("Current tree: " + ", ".join(str(value) + " " + key for key, value in counts.items()))

if __name__ == "__main__":
    main()
