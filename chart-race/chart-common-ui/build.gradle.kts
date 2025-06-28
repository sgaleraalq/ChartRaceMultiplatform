plugins {
    id("com.chart_race.kmp.library.multiplatform")
}

android {
    namespace = "com.sgale.chart_common_ui"


}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.chartRace.core)
            implementation(compose.components.resources)
        }
    }
}
