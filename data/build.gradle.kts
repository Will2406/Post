plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")

    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = Config.applicationDataId
    compileSdk = Config.compileSdkVersion

    defaultConfig {
        minSdk = Config.minSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        debug {
            buildConfigField("String", "BASE_URL", "\"https://jsonplaceholder.typicode.com/\"")
        }

        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        buildConfig = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation(Dependencies.AndroidX.CoreKtx)

    api(Dependencies.Retrofit.Retrofit)
    implementation(Dependencies.Retrofit.MoshiAdapter)

    implementation(Dependencies.Hilt.Hilt)
    kapt(Dependencies.Hilt.Compiler)

    implementation(Dependencies.Retrofit.Interceptor.OkHttp)
    implementation(Dependencies.Retrofit.Interceptor.Interceptor)

}