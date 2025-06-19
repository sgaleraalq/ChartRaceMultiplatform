plugins {
    id("com.sgale.kmp.multiplatform")
//    id("com.sgale.android.application")
//    id("com.sgale.android.application.compose")
//    id("com.sgale.android.hilt")
}

android {
    namespace = "com.sgale.chart_race"

    kotlin {
        sourceSets.configureEach {
            kotlin.srcDir(layout.buildDirectory.files("generated/ksp/$name/kotlin/"))
        }

        sourceSets.all {
            languageSettings {
                languageVersion = "2.0"
            }
        }
    }
}