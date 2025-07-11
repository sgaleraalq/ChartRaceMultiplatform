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

package com.sgale.convention.kmp.utils

object Plugins {
    const val KOTLIN_MULTIPLATFORM = "kotlinMultiplatform"
    const val ANDROID_APPLICATION = "androidApplication"
    const val COMPOSE_MULTIPLATFORM = "composeMultiplatform"
    const val COMPOSE_COMPILER = "composeCompiler"
    const val ANDROID_LIBRARY = "androidLibrary"
}

object KmpConfiguration {
    const val COMPOSE_RUNTIME = "compose.runtime"
    const val COMPOSE_FOUNDATION = "compose.foundation"
    const val COMPOSE_MATERIAL3 = "compose.material3"
    const val COMPOSE_UI = "compose.ui"
    const val COMPOSE_UI_TOOLING_PREVIEW = "compose.ui.tooling.preview"
    const val LIFECYCLE_VIEWMODEL = "androidx.lifecycle.viewmodel"
    const val LIFECYCLE_RUNTIME_COMPOSE = "androidx.lifecycle.runtimeCompose"

    const val KOTLIN_TEST = "kotlin.test"

    const val COMPOSE_UI_TOOLING = "compose.ui.tooling"

    //const val COMPOSE_COMPONENTS_RESOURCES = "org.jetbrains.compose.components:components-resources"
}


object AndroidConfiguration {
    const val ACTIVITY_COMPOSE = "androidx.activity.compose"
    const val COMPOSE_PREVIEW = "compose.preview"
}