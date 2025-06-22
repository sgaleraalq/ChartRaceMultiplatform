plugins {
    `kotlin-dsl`
}

group = "com.sgale.buildlogic"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.compose.compiler.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        /**
         * Kotlin Multiplatform
         */
        register("kmpAppMultiplatform") {
            id = "com.chart_race.kmp.app.multiplatform"
            implementationClass = "com.sgale.convention.kmp.KmpAppConventionPlugin"
        }
        register("kmpLibraryMultiplatform") {
            id = "com.chart_race.kmp.library.multiplatform"
            implementationClass = "com.sgale.convention.kmp.KmpLibraryConventionPlugin"
        }

        /**
         * Native Android
         */
        // Basic Android
        register("androidApplication") {
            id = "com.chart_race.android.application"
            implementationClass = "com.sgale.convention.android.AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = "com.chart_race.android.library"
            implementationClass = "com.sgale.convention.android.AndroidLibraryConventionPlugin"
        }

        // Android Compose
        register("androidComposeApplication") {
            id = "com.chart_race.android.application.compose"
            implementationClass = "com.sgale.convention.android.AndroidComposeApplicationConventionPlugin"
        }
        register("androidComposeLibrary") {
            id = "com.chart_race.android.library.compose"
            implementationClass = "com.sgale.convention.android.AndroidComposeLibraryConventionPlugin"
        }

        // Hilt
        register("androidHilt") {
            id = "com.chart_race.android.hilt"
            implementationClass = "com.sgale.convention.android.HiltConventionPlugin"
        }
    }
}