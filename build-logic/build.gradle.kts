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
         * Basic Android
         */
        register("androidApplication") {
            id = "com.sgale.android.application"
            implementationClass = "com.sgale.convention.AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = "com.sgale.android.library"
            implementationClass = "com.sgale.convention.AndroidLibraryConventionPlugin"
        }

        /**
         * Compose
         */
        register("androidComposeApplication") {
            id = "com.sgale.android.application.compose"
            implementationClass = "com.sgale.convention.AndroidComposeApplicationConventionPlugin"
        }
        register("androidComposeLibrary") {
            id = "com.sgale.android.library.compose"
            implementationClass = "com.sgale.convention.AndroidComposeLibraryConventionPlugin"
        }

        /**
         * Hilt
         */
        register("androidHilt") {
            id = "com.sgale.android.hilt"
            implementationClass = "com.sgale.convention.AndroidHiltConventionPlugin"
        }
    }
}