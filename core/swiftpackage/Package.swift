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
            targets: ["core"]
        ),
    ],
    targets: [
        .binaryTarget(
            name: "core",
            path: "../build/XCFrameworks/release/core.xcframework"
        ),
    ]
)
