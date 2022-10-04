buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(GradlePlugins.android)
        classpath(GradlePlugins.kotlin)
        classpath(GradlePlugins.kotlinSerialization)
    }
}

allprojects {
    // the only place where HostManager could be instantiated
    project.extra.apply {
        set("hostManager", hostManager)
    }

    repositories {
        mavenCentral()
    }
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}