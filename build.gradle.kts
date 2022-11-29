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
        classpath(GradlePlugins.firebaseDistribution)
    }
}

allprojects {
    project.extra.apply {
        // the only place where HostManager could be instantiated
        set("hostManager", hostManager)
        set("appVersion", "2.0.0")
    }

    repositories {
        google()
        mavenCentral()
    }
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}

tasks.register("printVersionName") {
    println(project.extra.get("appVersion"))
}