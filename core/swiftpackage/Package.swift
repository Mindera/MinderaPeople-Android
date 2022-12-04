// swift-tools-version:5.3
import PackageDescription

let package = Package(
    name: "MinderaPeopleKt",
    platforms: [
        .iOS(.v13)
    ],
    products: [
        .library(
            name: "MinderaPeopleKt",
            targets: ["core"] // "coreDebug", "coreRelease"
        ),
    ],
    targets: [
        .binaryTarget(
            name: "core",
            path: "../build/XCFrameworks/release/core.xcframework"
        ),
//         .binaryTarget(
//             name: "coreDebug",
//             path: "../build/XCFrameworks/debug/core.xcframework"
//         ),
//         .binaryTarget(
//             name: "coreRelease",
//             path: "../build/XCFrameworks/release/core.xcframework"
//         ),
    ]
)
