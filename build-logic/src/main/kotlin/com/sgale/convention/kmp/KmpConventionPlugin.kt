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

import com.android.build.gradle.BaseExtension
import com.sgale.convention.ProjectConfiguration.APPLICATION_ID
import com.sgale.convention.ProjectConfiguration.COMPILE_SDK
import com.sgale.convention.ProjectConfiguration.MIN_SDK
import com.sgale.convention.ProjectConfiguration.NAMESPACE
import com.sgale.convention.ProjectConfiguration.TARGET_SDK
import com.sgale.convention.ProjectConfiguration.VERSION_CODE
import com.sgale.convention.ProjectConfiguration.VERSION_NAME
import com.sgale.convention.kmp.KmpConfiguration.COMPOSE_FOUNDATION
import com.sgale.convention.kmp.KmpConfiguration.COMPOSE_MATERIAL3
import com.sgale.convention.kmp.KmpConfiguration.COMPOSE_RUNTIME
import com.sgale.convention.kmp.KmpConfiguration.COMPOSE_UI
import com.sgale.convention.kmp.KmpConfiguration.COMPOSE_UI_TOOLING_PREVIEW
import com.sgale.convention.kmp.KmpConfiguration.COMPOSE_VERSION
import com.sgale.convention.kmp.KmpConfiguration.LIFECYCLE_RUNTIME_COMPOSE
import com.sgale.convention.kmp.KmpConfiguration.LIFECYCLE_VIEWMODEL
import org.gradle.api.JavaVersion.VERSION_11
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KmpMultiplatformConventionPlugin : Plugin<Project> {
    private val composeVersion = COMPOSE_VERSION

    override fun apply(target: Project) = with(target) {
        val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

        plugins.apply(libs.findPlugin("kotlinMultiplatform").get().get().pluginId)
        plugins.apply(libs.findPlugin("androidApplication").get().get().pluginId)
        plugins.apply(libs.findPlugin("composeMultiplatform").get().get().pluginId)
        plugins.apply(libs.findPlugin("composeCompiler").get().get().pluginId)

        extensions.configure<BaseExtension> {
            namespace = NAMESPACE
            compileSdkVersion(COMPILE_SDK)
            defaultConfig {
                minSdk = MIN_SDK
                targetSdk = TARGET_SDK
                versionCode = VERSION_CODE
                versionName = VERSION_NAME
                applicationId = APPLICATION_ID
            }

            compileOptions {
                sourceCompatibility = VERSION_11
                targetCompatibility = VERSION_11
            }

            buildTypes {
                getByName("release") {
                    isMinifyEnabled = false
                }
            }

//            packagingOptions {
//                resources {
//                    excludes.add("/META-INF/{AL2.0,LGPL2.1}")
//                }
//            }
        }

        extensions.configure<KotlinMultiplatformExtension> {

            androidTarget {
                compilerOptions {
                    jvmTarget.set(JVM_11)
                }
            }

            val androidMain = sourceSets.getByName("androidMain")

            androidMain.dependencies {
                implementation(libs.findLibrary("androidx.activity.compose").get())
                implementation(composeDependency(COMPOSE_UI_TOOLING_PREVIEW))
            }

            listOf(
                iosX64(),
                iosArm64(),
                iosSimulatorArm64()
            ).forEach { iosTarget ->
                iosTarget.binaries.framework {
                    baseName = "ComposeApp"
                    isStatic = true
                }
            }


            val commonMain = sourceSets.getByName("commonMain")
            val commonTest = sourceSets.getByName("commonTest")

            commonMain.dependencies {
//                implementation(composeDependency(COMPOSE_COMPONENTS_RESOURCES))
                implementation(composeDependency(COMPOSE_RUNTIME))
                implementation(composeDependency(COMPOSE_FOUNDATION))
                implementation(composeDependency(COMPOSE_MATERIAL3))
                implementation(composeDependency(COMPOSE_UI))
                implementation(composeDependency(COMPOSE_UI_TOOLING_PREVIEW))
                implementation(libs.findLibrary(LIFECYCLE_VIEWMODEL).get())
                implementation(libs.findLibrary(LIFECYCLE_RUNTIME_COMPOSE).get())
            }

//            commonTest.dependencies {
//                implementation(libs.findLibrary(KOTLIN_TEST).get())
//            }
        }

//        dependencies {
//            add("implementation", libs.findLibrary(COMPOSE_COMPONENTS_UI_TOOLING).get())
//        }
    }

    private fun composeDependency(groupWithArtifact: String) = "$groupWithArtifact:$composeVersion"
}