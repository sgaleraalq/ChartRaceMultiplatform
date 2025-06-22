plugins {
    id("com.chart_race.kmp.app.multiplatform")
}

android {
    namespace = "com.sgale.chart_race"

    defaultConfig {
        applicationId = "com.sgale.chart_race"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0.0"
    }

    buildTypes {
        debug {
            applicationIdSuffix = ".debug"
        }
    }
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.chartRace.core)
            implementation(projects.chartRace.chartCommonUi)
            implementation(compose.components.resources)
        }
    }
}
