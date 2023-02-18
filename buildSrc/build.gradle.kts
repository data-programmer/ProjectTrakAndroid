plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
}

gradlePlugin {
    plugins {
        register("module-plugin") {
            id = "module-plugin"
            implementationClass = "com.kingsland.gradle.plugins.ModulePlugin"
        }
        register("app-plugin") {
            id = "app-plugin"
            implementationClass = "com.kingsland.gradle.plugins.AppPlugin"
        }
    }
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    compileOnly(gradleApi())
    implementation("com.android.tools.build:gradle:7.3.1")
    implementation(kotlin("gradle-plugin", "1.8.10"))
    implementation(kotlin("android-extensions"))
    implementation(kotlin("script-runtime"))
}