# Angy Brids

A [libGDX](https://libgdx.com/) project based on the game Angry Birds, generated with [gdx-liftoff](https://github.com/libgdx/gdx-liftoff).

This project was generated with a template including simple application launchers and a main class extending `Game` that sets the first screen.

## How to run the code

- Double-click on the `Angy Brids-1.0.0.jar` file
- Alternatively, to run through the terminal, go to the root directory of the project and run the following command:

```java -jar Angy\ Brids-1.0.0.jar```

If you prefer to run through an IDE, follow the steps given belown to run the project.

### IntelliJ Idea

- Open the `build.gradle` file and select "Open as Project"
- Open the Gradle Window by following these steps: `View -> Tool Windows -> Gradle`
- To run the program, double-click the `run` task, accessible through `lwjgl3 -> Tasks -> application`.

### Eclipse

- Choose `File -> Import -> Gradle -> Existing Gradle Project`
- Right-click the lwjgl3 project -> Run as -> Run Configurations
- Select Java Application (on the right side)
- Click the icon at top left to create a new run configuration
- Select the `Lwjgl3Launcher` class as the Main class
- Click on the Arguments Tab
- Under Working Directory (at the bottom), select Other -> Workspace
> For macOS, add `-XstartOnFirstThread` argument to VM options
- Select the assets folder


## Platforms

- `core`: Main module with the application logic shared by all platforms.
- `lwjgl3`: Primary desktop platform using LWJGL3; was called 'desktop' in older docs.

## Gradle

This project uses [Gradle](https://gradle.org/) to manage dependencies.
The Gradle wrapper was included, so you can run Gradle tasks using `gradlew.bat` or `./gradlew` commands.
Useful Gradle tasks and flags:

- `--continue`: when using this flag, errors will not stop the tasks from running.
- `--daemon`: thanks to this flag, Gradle daemon will be used to run chosen tasks.
- `--offline`: when using this flag, cached dependency archives will be used.
- `--refresh-dependencies`: this flag forces validation of all dependencies. Useful for snapshot versions.
- `build`: builds sources and archives of every project.
- `cleanEclipse`: removes Eclipse project data.
- `cleanIdea`: removes IntelliJ project data.
- `clean`: removes `build` folders, which store compiled classes and built archives.
- `eclipse`: generates Eclipse project data.
- `idea`: generates IntelliJ project data.
- `lwjgl3:jar`: builds application's runnable jar, which can be found at `lwjgl3/build/libs`.
- `lwjgl3:run`: starts the application.
- `test`: runs unit tests (if any).

Note that most tasks that are not specific to a single project can be run with `name:` prefix, where the `name` should be replaced with the ID of a specific project.
For example, `core:clean` removes `build` folder only from the `core` project.

## References

- [libGDX documentation](https://libgdx.com/wiki/)
- [Stack Overflow](https://stackoverflow.com/)
- [Quora](https://www.quora.com/)
- [Google Images](https://images.google.com/)
- [Angry Birds Official Website](https://www.angrybirds.com/)
