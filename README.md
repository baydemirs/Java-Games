# Java Games

A collection of three independent Java desktop games. The original repositories were imported with `git subtree` without squashing, preserving their original commits. Each game keeps its own source code and image resources and is compiled and launched separately.

## Games

| Game | Description | Entry point | Original repository |
| --- | --- | --- | --- |
| TicTacToe | A local two-player 3x3 tic-tac-toe game | `TicTacToe` | [TicTacToe](https://github.com/baydemirs/TicTacToe) |
| racingAnimal | A timer-driven race between three cars; the original repository name is retained | `RacingofAnimal` | [racingAnimal](https://github.com/baydemirs/racingAnimal) |
| FlappyBird | A bird-and-pipes game controlled with the Space key | `App` | [FlappyBird](https://github.com/baydemirs/FlappyBird) |

## Technologies

- Java SE, Swing and AWT; no third-party runtime libraries are referenced.
- NetBeans GUI forms and Ant project files for TicTacToe and racingAnimal.
- Manual `javac` compilation for FlappyBird and as an alternative for the other games.
- PNG resources and one GIF resource, kept with their respective games.

## Project structure

```text
Java-Games/
├── README.md
├── docs/
│   ├── migration-manifest.md
│   └── migration-manifest.json
├── scripts/
│   └── verify_migration.py
├── TicTacToe/
│   ├── LICENSE
│   ├── README.md
│   ├── build.xml
│   ├── manifest.mf
│   ├── nbproject/
│   └── src/                 # Java source, NetBeans form and images
├── racingAnimal/
│   ├── build.xml
│   ├── manifest.mf
│   ├── nbproject/
│   └── src/                 # Java source, NetBeans form and images
└── FlappyBird/
    └── src/                 # App.java, FlappyBird.java and images
```

## Requirements

- A JDK, not only a JRE, and a graphical desktop session.
- JDK 21 or newer for the existing TicTacToe and racingAnimal project targets.
- FlappyBird was independently compiled with JDK 17; no original Java version was declared.
- `java` and `javac` available on PATH. JDK 21 or newer can be used for all three games.
- PowerShell for the commands below. NetBeans is optional for manual compilation.
- Python 3 is optional and only used by the migration verification script.

Do not compile the games into one shared output directory. Keep the image folders on each game's runtime classpath.

## Running TicTacToe

From the repository root, in PowerShell:

```powershell
New-Item -ItemType Directory -Force TicTacToe/out | Out-Null
javac --release 21 -encoding UTF-8 -d TicTacToe/out TicTacToe/src/TicTacToe.java
Copy-Item -LiteralPath TicTacToe/src/images -Destination TicTacToe/out -Recurse -Force
java -cp TicTacToe/out TicTacToe
```

Alternatively, open the `TicTacToe` project folder in NetBeans with JDK 21 or newer and use Build/Run. Its Ant build files are retained; the NetBeans/Ant packaging path has not been verified during this migration.

## Running racingAnimal

From the repository root, in PowerShell:

```powershell
New-Item -ItemType Directory -Force racingAnimal/out | Out-Null
javac --release 21 -encoding UTF-8 -d racingAnimal/out racingAnimal/src/RacingofAnimal.java
Copy-Item -LiteralPath racingAnimal/src/images -Destination racingAnimal/out -Recurse -Force
java -cp racingAnimal/out RacingofAnimal
```

Alternatively, open the `racingAnimal` project folder in NetBeans with JDK 21 or newer and use Build/Run. The original restart behavior is retained. Restarting before the first race can encounter an uninitialized timer; this pre-existing issue is outside the migration scope.

## Running FlappyBird

From the repository root, in PowerShell:

```powershell
New-Item -ItemType Directory -Force FlappyBird/out | Out-Null
javac -encoding UTF-8 -d FlappyBird/out FlappyBird/src/App.java FlappyBird/src/FlappyBird.java
Copy-Item -LiteralPath FlappyBird/src/images -Destination FlappyBird/out -Recurse -Force
java -cp FlappyBird/out App
```

Use Space to jump and restart after game over. Images are loaded from the classpath, so the original machine-specific drive path is no longer required. Missing or unreadable required images produce an explicit startup error.

## Migration verification

```powershell
python scripts/verify_migration.py
```

The verifier checks the recorded original commit graph, all original tracked-file mappings, approved exclusions and current Git-normalized file contents. The manifest documents exactly which original files were retained, changed or removed from the working tree. Historical copies of excluded files remain in the preserved commits.

## License

TicTacToe retains its original Apache-2.0 license in `TicTacToe/LICENSE`. No repository-wide license is asserted for racingAnimal, FlappyBird or their assets, because their original repositories did not contain license files. Existing authorship notices are retained.
