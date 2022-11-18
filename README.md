# MinderaPeople Android

Project Dependencies:
- JDK <= 17
- Android Studio
- XCode (need to create iPhone 12 Simulator to run the Unit Tests)

## iOS -> XCFramework generation:

For iOS part, this project uses the [com.chromaticnoise.multiplatform-swiftpackage](https://github.com/ge-org/multiplatform-swiftpackage])

This is a 3rd part plugin that generates a XCFramework based on the KMM kotlin compiled code and creates a Swift Package.

This plugin has 2 gradle tasks:
- createSwiftPackage
- createXCFramework

The `createSwiftPackage` automatically runs the `createXCFramework` task.

For every code change on KMM module, it is necessary to re-run `createXCFramework` task to update the framework for iOS project.

This is mandatory to have the latest changes available for iOS project on Swift.

For now, the generated XCFramework is being committed on this repository, but is not mandatory.

The iOS pipeline file, runs the `createSwiftPackage`task.

## Android -> Navigation:

The Android Navigation follows the Graph and Sub-Graph principle:
- The main navigator (App navigator) only knows how to go to a `feature route`.
- The feature route defines its own internal navigation (see the `UserNavigation.kt`)
