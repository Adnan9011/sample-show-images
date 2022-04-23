object Dependency {

    val APP_COMPAT by lazy { "androidx.appcompat:appcompat:${Version.appcompatVersion}" }
    val MATERIAL by lazy { "com.google.android.material:material:${Version.materialVersion}" }
    val CONSTRAINT by lazy { "androidx.constraintlayout:constraintlayout:${Version.constraintlayoutVersion}" }
    val JUNIT by lazy { "junit:junit:${Version.junitVersion}" }
    val TEST_JUNIT by lazy { "androidx.test.ext:junit:${Version.testJunitVersion}" }
    val ESPRESSO by lazy { "androidx.test.espresso:espresso-core:${Version.espressoVersion}" }

    // Rx
    val RX_ANDROID by lazy { "io.reactivex.rxjava2:rxandroid:${Version.rxAndroidVersion}" }
    val RX_JAVA by lazy { "io.reactivex.rxjava2:rxjava:${Version.rxJavaVersion}" }

    // Hilt
    val HILT_ANDROID by lazy { "com.google.dagger:hilt-android:${Version.hiltVersion}" }
    val HILT_COMPILER by lazy { "com.google.dagger:hilt-compiler:${Version.hiltVersion}" }
    val HILT_WORK by lazy { "androidx.hilt:hilt-work:${Version.hiltWorkVersion}" }

    // Retrofit
    val RETROFIT by lazy { "com.squareup.retrofit2:retrofit:${Version.retrofitVersion}" }
    val RETROFIT_GSON by lazy { "com.squareup.retrofit2:converter-gson:${Version.retrofitVersion}" }
    val RETROFIT_LOGGING by lazy { "com.squareup.okhttp3:logging-interceptor:${Version.loggingInterceptorVersion}" }

    // Ktx
    val KTS_CORE by lazy { "androidx.core:core-ktx:${Version.ktxCoreVersion}" }
    val KTS_ACTIVITY by lazy { "androidx.activity:activity-ktx:${Version.ktxActivityVerstion}" }
    val KTS_FRAGMENT by lazy { "androidx.fragment:fragment-ktx:${Version.ktxFragmentVerstion}" }
    val KTS_LIFECYCLE by lazy { "androidx.lifecycle:lifecycle-livedata-ktx:${Version.ktxLifecycleVerstion}" }

    // Glide
    val GLIDE by lazy { "com.github.bumptech.glide:glide:${Version.glideVersion}" }

    // Room components
    val ROOM_KTS by lazy { "androidx.room:room-ktx:${Version.roomVersion}" }
    val ROOM_COMPILER by lazy { "androidx.room:room-compiler:${Version.roomVersion}" }
    val ROOM_TESTING by lazy { "androidx.room:room-testing:${Version.roomVersion}" }
}
