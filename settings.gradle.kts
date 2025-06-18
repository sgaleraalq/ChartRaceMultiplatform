pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ChartRaceMultiplatform"
include(":app")
include(":chart-race:chart-core")
include(":chart-race:chart-ui-compose")
include(":chart-race:chart-ui-ios")
