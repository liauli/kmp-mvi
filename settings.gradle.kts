pluginManagement {
    repositories {
        google()
        jcenter()
        gradlePluginPortal()
        mavenCentral()
    }
    
}
rootProject.name = "MyApplication"


include(":androidApp")
include(":shared")
enableFeaturePreview("GRADLE_METADATA")
