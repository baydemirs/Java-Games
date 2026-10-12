# Migration manifest

Migration date: 2026-10-12. Imported using `git subtree add` without `--squash`. Original commits remain reachable with their original object IDs; their historical paths are unchanged. No original repository was modified.

## Source snapshots

| Game | Original tip | Original commits |
| --- | --- | --- |
| TicTacToe | `7d52ca92f4c9ef5be8c1a48b5a9867e28ca0f96a` | 2 |
| racingAnimal | `ae1bb922742775d92a3eca590374e8d34da6bcab` | 2 |
| FlappyBird | `81db8a28de9a701605ca16afb4d69772bd6ae361` | 2 |

## Scope and totals

57 original tracked files: 34 retained unchanged, 1 modified, 22 excluded from the current working tree but preserved in history.

The repeated inner NetBeans project folders were flattened. All four Java source files, both NetBeans forms, ten original images, both build configurations and the TicTacToe license are retained. Only `FlappyBird/src/FlappyBird.java` changes source content. Its four absolute image paths are replaced by classpath lookups with explicit validation. racingAnimal restart behavior is unchanged.

The JSON companion records the complete source paths, original Git blob IDs, SHA-256 hashes of original Git blob bytes and expected destination blob IDs. Git normalization avoids false differences caused by checkout line endings.

## File mapping

| Game | Original path | Destination path | Status |
| --- | --- | --- | --- |
| TicTacToe | `.gitattributes` | `TicTacToe/.gitattributes` | unchanged |
| TicTacToe | `.gitignore` | `TicTacToe/.gitignore` | unchanged |
| TicTacToe | `LICENSE` | `TicTacToe/LICENSE` | unchanged |
| TicTacToe | `README.md` | `TicTacToe/README.md` | unchanged |
| TicTacToe | `TicTacToe/build.xml` | `TicTacToe/build.xml` | unchanged |
| TicTacToe | `TicTacToe/build/classes/.netbeans_automatic_build` | `TicTacToe/build/classes/.netbeans_automatic_build` | excluded |
| TicTacToe | `TicTacToe/build/classes/.netbeans_update_resources` | `TicTacToe/build/classes/.netbeans_update_resources` | excluded |
| TicTacToe | `TicTacToe/build/classes/TicTacToe.form` | `TicTacToe/build/classes/TicTacToe.form` | excluded |
| TicTacToe | `TicTacToe/build/classes/images/Tic_tac_toe.svg.png` | `TicTacToe/build/classes/images/Tic_tac_toe.svg.png` | excluded |
| TicTacToe | `TicTacToe/manifest.mf` | `TicTacToe/manifest.mf` | unchanged |
| TicTacToe | `TicTacToe/nbproject/build-impl.xml` | `TicTacToe/nbproject/build-impl.xml` | unchanged |
| TicTacToe | `TicTacToe/nbproject/genfiles.properties` | `TicTacToe/nbproject/genfiles.properties` | unchanged |
| TicTacToe | `TicTacToe/nbproject/private/private.properties` | `TicTacToe/nbproject/private/private.properties` | excluded |
| TicTacToe | `TicTacToe/nbproject/private/private.xml` | `TicTacToe/nbproject/private/private.xml` | excluded |
| TicTacToe | `TicTacToe/nbproject/project.properties` | `TicTacToe/nbproject/project.properties` | unchanged |
| TicTacToe | `TicTacToe/nbproject/project.xml` | `TicTacToe/nbproject/project.xml` | unchanged |
| TicTacToe | `TicTacToe/src/TicTacToe.form` | `TicTacToe/src/TicTacToe.form` | unchanged |
| TicTacToe | `TicTacToe/src/TicTacToe.java` | `TicTacToe/src/TicTacToe.java` | unchanged |
| TicTacToe | `TicTacToe/src/images/Tic_tac_toe.svg.png` | `TicTacToe/src/images/Tic_tac_toe.svg.png` | unchanged |
| racingAnimal | `.gitattributes` | `racingAnimal/.gitattributes` | unchanged |
| racingAnimal | `racingAnimal/.DS_Store` | `racingAnimal/.DS_Store` | excluded |
| racingAnimal | `racingAnimal/build.xml` | `racingAnimal/build.xml` | unchanged |
| racingAnimal | `racingAnimal/build/classes/.netbeans_automatic_build` | `racingAnimal/build/classes/.netbeans_automatic_build` | excluded |
| racingAnimal | `racingAnimal/build/classes/.netbeans_update_resources` | `racingAnimal/build/classes/.netbeans_update_resources` | excluded |
| racingAnimal | `racingAnimal/build/classes/RacingofAnimal$1.class` | `racingAnimal/build/classes/RacingofAnimal$1.class` | excluded |
| racingAnimal | `racingAnimal/build/classes/RacingofAnimal$2.class` | `racingAnimal/build/classes/RacingofAnimal$2.class` | excluded |
| racingAnimal | `racingAnimal/build/classes/RacingofAnimal$3.class` | `racingAnimal/build/classes/RacingofAnimal$3.class` | excluded |
| racingAnimal | `racingAnimal/build/classes/RacingofAnimal$4.class` | `racingAnimal/build/classes/RacingofAnimal$4.class` | excluded |
| racingAnimal | `racingAnimal/build/classes/RacingofAnimal.class` | `racingAnimal/build/classes/RacingofAnimal.class` | excluded |
| racingAnimal | `racingAnimal/build/classes/RacingofAnimal.form` | `racingAnimal/build/classes/RacingofAnimal.form` | excluded |
| racingAnimal | `racingAnimal/build/classes/images/Vehicle-Red-Car (1).png` | `racingAnimal/build/classes/images/Vehicle-Red-Car (1).png` | excluded |
| racingAnimal | `racingAnimal/build/classes/images/aticon1.gif` | `racingAnimal/build/classes/images/aticon1.gif` | excluded |
| racingAnimal | `racingAnimal/build/classes/images/car_right_1.png` | `racingAnimal/build/classes/images/car_right_1.png` | excluded |
| racingAnimal | `racingAnimal/build/classes/images/car_right_2.png` | `racingAnimal/build/classes/images/car_right_2.png` | excluded |
| racingAnimal | `racingAnimal/build/classes/images/car_right_3.png` | `racingAnimal/build/classes/images/car_right_3.png` | excluded |
| racingAnimal | `racingAnimal/manifest.mf` | `racingAnimal/manifest.mf` | unchanged |
| racingAnimal | `racingAnimal/nbproject/build-impl.xml` | `racingAnimal/nbproject/build-impl.xml` | unchanged |
| racingAnimal | `racingAnimal/nbproject/genfiles.properties` | `racingAnimal/nbproject/genfiles.properties` | unchanged |
| racingAnimal | `racingAnimal/nbproject/private/private.properties` | `racingAnimal/nbproject/private/private.properties` | excluded |
| racingAnimal | `racingAnimal/nbproject/private/private.xml` | `racingAnimal/nbproject/private/private.xml` | excluded |
| racingAnimal | `racingAnimal/nbproject/project.properties` | `racingAnimal/nbproject/project.properties` | unchanged |
| racingAnimal | `racingAnimal/nbproject/project.xml` | `racingAnimal/nbproject/project.xml` | unchanged |
| racingAnimal | `racingAnimal/src/RacingofAnimal.form` | `racingAnimal/src/RacingofAnimal.form` | unchanged |
| racingAnimal | `racingAnimal/src/RacingofAnimal.java` | `racingAnimal/src/RacingofAnimal.java` | unchanged |
| racingAnimal | `racingAnimal/src/images/Vehicle-Red-Car (1).png` | `racingAnimal/src/images/Vehicle-Red-Car (1).png` | unchanged |
| racingAnimal | `racingAnimal/src/images/aticon1.gif` | `racingAnimal/src/images/aticon1.gif` | unchanged |
| racingAnimal | `racingAnimal/src/images/car_right_1.png` | `racingAnimal/src/images/car_right_1.png` | unchanged |
| racingAnimal | `racingAnimal/src/images/car_right_2.png` | `racingAnimal/src/images/car_right_2.png` | unchanged |
| racingAnimal | `racingAnimal/src/images/car_right_3.png` | `racingAnimal/src/images/car_right_3.png` | unchanged |
| FlappyBird | `.gitattributes` | `FlappyBird/.gitattributes` | unchanged |
| FlappyBird | `.gitignore` | `FlappyBird/.gitignore` | unchanged |
| FlappyBird | `src/App.java` | `FlappyBird/src/App.java` | unchanged |
| FlappyBird | `src/FlappyBird.java` | `FlappyBird/src/FlappyBird.java` | modified |
| FlappyBird | `src/images/bottompipe.png` | `FlappyBird/src/images/bottompipe.png` | unchanged |
| FlappyBird | `src/images/flappybird.png` | `FlappyBird/src/images/flappybird.png` | unchanged |
| FlappyBird | `src/images/flappybirdbg.png` | `FlappyBird/src/images/flappybirdbg.png` | unchanged |
| FlappyBird | `src/images/toppipe.png` | `FlappyBird/src/images/toppipe.png` | unchanged |

## Verification boundaries

Independent manual compilation and resource/startup checks are recorded separately in `validation.md`. A successful compilation is not a full gameplay test. NetBeans/Ant packaging remains unverified. No GitHub repository creation, remote configuration or push has been performed.
