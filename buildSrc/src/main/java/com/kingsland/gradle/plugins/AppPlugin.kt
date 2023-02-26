package com.kingsland.gradle.plugins

import com.android.build.gradle.AppExtension
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class AppPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.plugins.apply("com.android.application")
        project.plugins.apply("kotlin-android")
        project.plugins.apply("kotlin-kapt")
        val androidExtension = project.extensions.getByName("android")
        if (androidExtension is BaseExtension) {
            androidExtension.apply {
                compileSdkVersion(Versions.COMPILE_SDK)
                defaultConfig {
                    targetSdk = Versions.TARGET_SDK
                    minSdk = Versions.MIN_SDK
                    versionCode = Versions.APP_VERSION_CODE
                    versionName = Versions.APP_VERSION_NAME
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }
                val proguardFile = "proguard-rules.pro"
                when (this) {
                    is LibraryExtension -> defaultConfig {
                        consumerProguardFiles(proguardFile)
                    }
                    is AppExtension -> buildTypes {
                        getByName("release") {
                            isMinifyEnabled = true
                            isShrinkResources = true
                            debuggable(false)
                            proguardFile(proguardFile)
                        }
                        getByName("debug") {
                            isMinifyEnabled = false
                            isShrinkResources = false
                            debuggable(true)
                            proguardFile(proguardFile)
                        }
                    }
                }
                composeOptions.kotlinCompilerExtensionVersion = Versions.KOTLIN_COMPILER_EXTENSION
                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_1_8
                    targetCompatibility = JavaVersion.VERSION_1_8
                }
                project.tasks.withType(KotlinCompile::class.java).configureEach {
                    kotlinOptions {
                        jvmTarget = Versions.JVM_TARGET
                    }
                }
            }
        }
    }
}