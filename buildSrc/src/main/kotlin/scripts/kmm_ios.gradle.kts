package scripts

import Dependencies
import isMacOsMachine

plugins {
    kotlin("multiplatform") apply false
    id("com.chromaticnoise.multiplatform-swiftpackage")
}

if (isMacOsMachine()) {

val moduleFrameworkName = "MinderaPeopleKt"

kotlin {
    // add a platform switching to have an IDE support
 // const val buildForDevice = project.findProperty('kotlin.native.cocoapods.target') == 'ios_arm'
 // const val buildForDevice = project.findProperty('device')?.toBoolean() ?: false

    ios {
        binaries {
            framework {
                baseName = moduleFrameworkName
            }
        }
    }

    sourceSets {
        val iosMain by getting {
            dependencies {
                implementation(Dependencies.ktorClientDarwin)
            }
        }
    }

    multiplatformSwiftPackage {
        packageName(moduleFrameworkName)
        swiftToolsVersion("5.3")
        targetPlatforms {
            iOS { v("13") }
        }
    }
}

}