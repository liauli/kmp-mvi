pluginManagement {
    repositories {
        google()
        jcenter()
        gradlePluginPortal()
        mavenCentral()
    }
    
}
rootProject.name = "kmp-mvi"


include(":androidApp")
include(":shared")
enableFeaturePreview("GRADLE_METADATA")
