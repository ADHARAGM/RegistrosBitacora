plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.registrosbitacora"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.registrosbitacora"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    viewBinding{
        enable=true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    //retrofit
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    //corrutinas
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")
    //DataStore (Bd)
    implementation("androidx.datastore:datastore-preferences:1.1.1")
    //mvvm (viewModel)
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.3")
    //liveData conexion entre la activity y el viewmode
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.3")
    //facilita vm Fragment
    implementation("androidx.fragment:fragment-ktx:1.8.1")
    //facilita vm Activity
    implementation("androidx.activity:activity-ktx:1.9.0")
    //set timeout
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
}