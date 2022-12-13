# MinderaPeople Android

Project Dependencies:
- JDK <= 17
- Android Studio
- XCode (need to create iPhone 12 Simulator to run the Unit Tests)

## iOS -> XCFramework generation

For iOS part, the KMM library is distribute as a Swift Package.
See [core/swiftpackage](./core/swiftpackage) folder. 

There is a gradle tasks `core:assembleXCFramework` that generates the XCFramework that is delivered by the Swift Package.
Please, check the content of the [core/swiftpackage/Package.swift](./core/swiftpackage/Package.swift).

For every code change on KMM module, it is necessary to re-run gradle task to update the framework for iOS project.

This is mandatory to have the latest changes available for iOS project on Swift.

The iOS pipeline file, runs the `core:assembleXCFramework` task.

## Android -> Navigation

The Android Navigation follows the Graph and Sub-Graph principle:
- The main navigator (App navigator) only knows how to go to a `feature route`.
- The feature route defines its own internal navigation (see the `UserNavigation.kt`)
