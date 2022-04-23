plugins {
    id(Plugin.APPLICACTION)
    id(Plugin.KOTLIN)
    id(Plugin.PARCELIZE)
    id(Plugin.HILT)
    kotlin(Plugin.KAPT)
}

android {
    compileSdk = ConfigData.compileSdk

    defaultConfig {
        applicationId = ConfigData.applicationId
        minSdk = ConfigData.minSdk
        targetSdk = ConfigData.targetSdk
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = Plugin.runner

        buildConfigField("String", "BASEURL", ConfigData.BaseUrl)
        // Fake data
        buildConfigField("String", "SHARED_ID", ConfigData.SharedId)
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
        jvmTarget = Plugin.jvmTarget
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(Dependency.APP_COMPAT)
    implementation(Dependency.MATERIAL)
    implementation(Dependency.CONSTRAINT)
    testImplementation(Dependency.JUNIT)
    androidTestImplementation(Dependency.TEST_JUNIT)
    androidTestImplementation(Dependency.ESPRESSO)

    // Rx
    implementation(Dependency.RX_ANDROID)
    implementation(Dependency.RX_JAVA)

    // Hilt
    implementation(Dependency.HILT_ANDROID)
    kapt(Dependency.HILT_COMPILER)
    implementation(Dependency.HILT_WORK)

    // Retrofit
    implementation(Dependency.RETROFIT)
    implementation(Dependency.RETROFIT_GSON)
    implementation(Dependency.RETROFIT_LOGGING)

    // Ktx
    implementation(Dependency.KTS_CORE)
    implementation(Dependency.KTS_ACTIVITY)
    implementation(Dependency.KTS_FRAGMENT)
    implementation(Dependency.KTS_LIFECYCLE)

    // Glide
    implementation(Dependency.GLIDE)

    // Room components
    implementation(Dependency.ROOM_KTS)
    kapt(Dependency.ROOM_COMPILER)
    androidTestImplementation(Dependency.ROOM_TESTING)
}