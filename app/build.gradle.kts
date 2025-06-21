plugins {
    id("com.sgale.kmp.multiplatform")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(compose.components.resources)
        }
    }
}
