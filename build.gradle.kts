// Top-level build file where you can add configuration options com.example.kiliaro.common to all sub-projects/modules.
buildscript {

    dependencies {
        classpath(ClassPath.HILT)
    }
}

plugins {
    id(Plugin.APPLICACTION) version (Version.applicationPluginVersion) apply false
    id(Plugin.LIBRARY) version (Version.libraryPluginVersion) apply false
    id(Plugin.KOTLIN) version (Version.kotlinPluginVersion) apply false
}

tasks {
    register("clean", Delete::class) {
        delete(rootProject.buildDir)
    }
}