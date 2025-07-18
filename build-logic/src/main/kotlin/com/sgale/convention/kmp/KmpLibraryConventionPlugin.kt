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

package com.sgale.convention.kmp

import com.android.build.gradle.LibraryExtension
import com.sgale.convention.configureKotlinAndroid
import com.sgale.convention.kmp.utils.KmpConfiguration.COMPOSE_UI_TOOLING
import com.sgale.convention.kmp.utils.configureAndroidKmp
import com.sgale.convention.kmp.utils.configureCommonDependencies
import com.sgale.convention.kmp.utils.configureiOSKmp
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KmpLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

        with(pluginManager) {
            apply("com.android.library")
            apply("org.jetbrains.kotlin.multiplatform")
            apply("org.jetbrains.compose")
            apply("org.jetbrains.kotlin.plugin.compose")
        }

        extensions.configure<LibraryExtension> {
            configureKotlinAndroid(this)
            defaultConfig.targetSdk = 35
        }

        extensions.configure<KotlinMultiplatformExtension> {
            configureCommonDependencies(libs)
            configureAndroidKmp(libs)
            configureiOSKmp()
        }

        dependencies {
            add("debugImplementation", libs.findLibrary(COMPOSE_UI_TOOLING).get())
        }
    }
}
