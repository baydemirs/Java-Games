# Local validation results

Date: 2026-10-12. Validation was performed before publication. No GitHub repository was created and no push was performed.

## Independent compilation

| Game | Compiler | Target | Result |
| --- | --- | --- | --- |
| TicTacToe | Android Studio JBR `javac 25.0.3` | `--release 21` | PASS |
| racingAnimal | Android Studio JBR `javac 25.0.3` | `--release 21` | PASS |
| FlappyBird | Temurin `javac 17.0.20` | `--release 17` | PASS |

All sources were compiled directly from the new repository, in separate temporary output folders with UTF-8 encoding and `-Xlint:all`. Original tracked `.class` files were not used. Image folders were copied to the respective output classpaths. Existing serialVersionUID and constructor this-escape warnings remain; they are outside this migration's scope. A Java 21-target compilation is verified, but execution on a Java 21 runtime was not performed; those two games were started on JBR 25.

## Startup and image checks

The reusable test harness is `scripts/smoke/JavaGamesSmoke.java`. It calls each game's actual `main` method, verifies a visible and displayable Swing window, and disposes the windows it opens. It also checks classpath resource decoding with `ImageIO`. For FlappyBird, it verifies the actual four loaded Image fields and stops its timers during cleanup.

| Check | Result |
| --- | --- |
| TicTacToe: entry point and visible window, 653 x 694 | PASS |
| racingAnimal: entry point and visible Racing of Cars window, 860 x 576 | PASS |
| FlappyBird: entry point and visible Flappy Bird window, 360 x 640 | PASS |
| All 10 original images found and decoded from separate classpaths | PASS |
| Actual FlappyBird background, bird and both pipe images have valid dimensions | PASS |
| Missing FlappyBird resource throws IllegalStateException with a missing-resource diagnostic | PASS |
| Invalid FlappyBird image throws IllegalStateException with an image-load diagnostic | PASS |
| Startup from a temporary working directory unrelated to the game sources | PASS |

This is a startup/resource smoke test, not visual screenshot review or an end-to-end gameplay test. Keyboard focus, complete rounds, collisions, scoring and restart behavior were not exercised. racingAnimal logic was not changed.

To reuse the harness, compile it with `javac --release 17 -encoding UTF-8 -d <probe-output> scripts/smoke/JavaGamesSmoke.java`. For the FlappyBird negative check, create a plain-text file named `images/_invalid_test.png` only in a temporary game output directory. Do not create `images/_missing_test.png`. Run `java -cp "<probe-output>;<game-output>" JavaGamesSmoke <entry-point> <image-filenames...>` on Windows. Use the entry points from README and include every original image filename (quote filenames containing spaces). Use Java 21 or newer for Java 21-target outputs. The harness opens and closes real game windows.

## Provenance and source comparison

- All six original commits remain ancestors of the migration branch, with their original object IDs.
- `git fsck --full` completed successfully.
- All 57 original tracked files are accounted for: 34 unchanged, one modified, 22 excluded from the working tree and retained in history.
- Every unchanged destination has the same Git-normalized blob ID as its original source, including both Java sources in NetBeans projects, App.java, both .form files, all 10 original images and TicTacToe/LICENSE.
- FlappyBird.java was additionally reconstructed back to its original image-loading implementation for comparison: removing the new helper and restoring the four original load expressions produces the exact original Git blob text. No game logic differs.
- Source hashes and file mappings are in migration-manifest.json and checked with `python scripts/verify_migration.py`.
- The original local FlappyBird checkout remained clean and at `81db8a28de9a701605ca16afb4d69772bd6ae361`; its eight tracked files still match the original snapshot.

## Remaining limitations

NetBeans/Ant packaging has not been executed. GUI appearance has not been reviewed using screenshots. The pre-existing racingAnimal restart issues and FlappyBird keyboard-focus behavior remain outside the approved scope. There is no repository-wide license claim.
