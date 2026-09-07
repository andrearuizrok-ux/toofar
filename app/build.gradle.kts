plugins { id("com.android.application") }

android {
    namespace = "com.toofar.app"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.toofar.app"
        minSdk = 24
        targetSdk = 35
        versionCode = 10
        versionName = "1.0.0-beta"
    }

    buildTypes {
        release { isMinifyEnabled = false }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
