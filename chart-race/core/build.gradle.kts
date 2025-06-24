plugins {
    id("com.chart_race.kmp")
}

android {
    namespace = "com.sgale.chart_core"
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(libs.diamondedge.logging)
                api(libs.koin.core)
            }
        }
    }
}