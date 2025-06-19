/*
 * Designed and developed by 2025 sgaleraalq (Sergio Galera)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sgale.convention.android.helper

import com.android.build.api.dsl.CommonExtension
import com.android.build.gradle.BaseExtension
import com.sgale.convention.ProjectConfiguration.COMPILE_SDK
import com.sgale.convention.ProjectConfiguration.MIN_SDK
import org.gradle.api.JavaVersion.VERSION_17
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

internal fun Project.configureKotlinAndroid(
    commonExtension: CommonExtension<*, *, *, *, *, *>
) {
    commonExtension.apply {
        compileSdk = COMPILE_SDK

        defaultConfig {
            minSdk = MIN_SDK
        }

        packaging.resources.excludes += "/META-INF/{AL2.0,LGPL2.1}"

        compileOptions {
            sourceCompatibility = VERSION_17
            targetCompatibility = VERSION_17
        }

        lint {
            abortOnError = false
        }
    }
}

internal fun Project.configureKotlinAndroid(
    extension: KotlinAndroidProjectExtension
) {
    extension.apply {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }
}

internal fun Project.configureSourceSets() {
    val android = extensions.getByName("android") as BaseExtension

    android.sourceSets.getByName("main").java.srcDirs("src/main/kotlin")
    android.sourceSets.getByName("test").java.srcDirs("src/test/kotlin")
    android.sourceSets.getByName("androidTest").java.srcDirs("src/androidTest/kotlin")
}