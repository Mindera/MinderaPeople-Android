package scripts

import Dependencies
import isMacOsMachine
import org.jetbrains.kotlin.gradle.plugin.mpp.BitcodeEmbeddingMode

plugins {
    kotlin("multiplatform") apply false
    id("com.chromaticnoise.multiplatform-swiftpackage")
    id("co.touchlab.crashkios.crashlyticslink")
}

if (isMacOsMachine()) {

val moduleFrameworkName = "MinderaPeopleKt"

kotlin {
    // add a platform switching to have an IDE support
 // const val buildForDevice = project.findProperty('kotlin.native.cocoapods.target') == 'ios_arm'
 // const val buildForDevice = project.findProperty('device')?.toBoolean() ?: false

    ios {
        binaries.framework {
            baseName = moduleFrameworkName
            isStatic = false
            // necessary to make linker works with Kermit library
            embedBitcode = BitcodeEmbeddingMode.DISABLE
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