buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(GradlePlugins.android)
        classpath(GradlePlugins.kotlin)
        classpath(GradlePlugins.kotlinSerialization)
        classpath(GradlePlugins.kermit)
        classpath(GradlePlugins.googleServices)
        classpath(GradlePlugins.firebaseCrashlytics)
    }
}

allprojects {
    // the only place where HostManager could be instantiated
    project.extra.apply {
        set("hostManager", hostManager)
    }

    repositories {
        google()
        mavenCentral()
    }
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}