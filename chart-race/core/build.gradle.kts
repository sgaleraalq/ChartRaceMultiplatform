plugins {
    id("com.chart_race.kmp")
}

android {
    namespace = "com.sgale.chart_core"
}

kotlin {
    sourceSets {
        androidMain {
            dependencies {
                implementation(libs.koin.android)
            }
        }
        commonMain {
            dependencies {
                api(libs.diamondedge.logging)

                api(project.dependencies.platform(libs.koin.bom))
                api(libs.koin.core)
                api(libs.koin.compose)
                api(libs.koin.compose.viewmodel)
            }
        }
    }
}
//
//// KSP Tasks
//dependencies {
//    add("kspCommonMainMetadata", libs.koin.ksp.compiler)
//    add("kspAndroid", libs.koin.ksp.compiler)
//    add("kspIosX64", libs.koin.ksp.compiler)
//    add("kspIosArm64", libs.koin.ksp.compiler)
//    add("kspIosSimulatorArm64", libs.koin.ksp.compiler)
//}
//
//// Trigger Common Metadata Generation from Native tasks
//project.tasks.withType(KotlinCompilationTask::class.java).configureEach {
//    if(name != "kspCommonMainKotlinMetadata") {
//        dependsOn("kspCommonMainKotlinMetadata")
//    }
//}