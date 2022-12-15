package scripts

import Dependencies
import isMacOsMachine
import org.jetbrains.kotlin.gradle.plugin.mpp.BitcodeEmbeddingMode
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    kotlin("multiplatform") apply false
    id("co.touchlab.crashkios.crashlyticslink")
}

if (isMacOsMachine()) {

val moduleFrameworkName = "MinderaPeopleKt"

kotlin {
    // add a platform switching to have an IDE support
 // const val buildForDevice = project.findProperty('kotlin.native.cocoapods.target') == 'ios_arm'
 // const val buildForDevice = project.findProperty('device')?.toBoolean() ?: false

    val xcf = XCFramework()
    ios {
        binaries.framework {
            baseName = moduleFrameworkName
            isStatic = false
            // necessary to make linker works with Kermit library
            embedBitcode = BitcodeEmbeddingMode.DISABLE
            xcf.add(this)
        }
    }

    sourceSets {
        val iosMain by getting {
            dependencies {
                implementation(Dependencies.ktorClientDarwin)
            }
        }
    }
}

exec {
    val xCodeProj = "MinderaPeople.xcodeproj"
    val version = project.extra.get("appVersion")
    println("setting iOS App version to $version")
    workingDir("${rootDir}/ios")
    commandLine("sed", "-i", "''", "-e", "s/MARKETING_VERSION \\= [^\\\\;]*\\;/MARKETING_VERSION = $version;/", "$xCodeProj/project.pbxproj")
}

}