import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING
import com.codingfeline.buildkonfig.gradle.TargetConfigDsl
import java.util.Properties

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.build.konfig)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation(libs.napier.aakira)
            implementation(libs.kotlinx.coroutines.core)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }

        androidMain.dependencies {
            implementation(libs.ktor.client.okhttp)
        }

        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }
    }
}

android {
    namespace = "com.example.marvellist"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

}

buildkonfig {
    packageName = "com.example.marvellist"

    val localProperties = Properties().apply {
        val propsFile = rootProject.file("local.properties")
        if(propsFile.exists()){
            load(propsFile.inputStream())
        }
    }

    // default config is required
    defaultConfigs {
        buildConfigField(STRING, "API_KEY_PRIVATE", localProperties["API_KEY_PRIVATE"].toString())
        buildConfigField(STRING, "API_KEY_PUBLIC", localProperties["API_KEY_PUBLIC"].toString())
    }
    // flavor is passed as a first argument of defaultConfigs
    defaultConfigs("dev") {
        buildConfigField(STRING, "API_KEY_PRIVATE", localProperties["API_KEY_PRIVATE"].toString())
        buildConfigField(STRING, "API_KEY_PUBLIC", localProperties["API_KEY_PUBLIC"].toString())
    }

    targetConfigs {
        create("android") {
            buildConfigField(STRING, "API_KEY_PRIVATE", localProperties["API_KEY_PRIVATE"].toString())
            buildConfigField(STRING, "API_KEY_PUBLIC", localProperties["API_KEY_PUBLIC"].toString())
        }

        create("ios") {
            buildConfigField(STRING, "API_KEY_PRIVATE", localProperties["API_KEY_PRIVATE"].toString())
            buildConfigField(STRING, "API_KEY_PUBLIC", localProperties["API_KEY_PUBLIC"].toString())
        }
    }
    // flavor is passed as a first argument of targetConfigs
    targetConfigs("dev") {
        create("ios") {
            buildConfigField(STRING, "API_KEY_PRIVATE", localProperties["API_KEY_PRIVATE"].toString())
            buildConfigField(STRING, "API_KEY_PUBLIC", localProperties["API_KEY_PUBLIC"].toString())
        }

        create("android") {
            buildConfigField(STRING, "API_KEY_PRIVATE", localProperties["API_KEY_PRIVATE"].toString())
            buildConfigField(STRING, "API_KEY_PUBLIC", localProperties["API_KEY_PUBLIC"].toString())
        }
    }
}



//spotless {
//    kotlin {
//        target("**/*.kt")
//        ktlint() // Uses ktlint for formatting
//    }
//}