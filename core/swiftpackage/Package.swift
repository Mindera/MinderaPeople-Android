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
            targets: ["MinderaPeopleKt"]
        ),
    ],
    targets: [
        .binaryTarget(
            name: "MinderaPeopleKt",
            path: "./MinderaPeopleKt.xcframework"
        ),
    ]
)
