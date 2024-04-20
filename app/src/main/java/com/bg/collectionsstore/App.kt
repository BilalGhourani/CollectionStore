package com.bg.collectionsstore

import android.app.Application
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    companion object {
        private lateinit var instance: App
        fun getInstance(): App {
            return instance
        }
    }

    private lateinit var database: FirebaseFirestore

    override fun onCreate() {
        super.onCreate()
        instance = this
        initFirebase()
        database = FirebaseFirestore.getInstance()
    }

    private fun initFirebase() {
        // Initialize Firebase only once (preferably in onCreate)
        val options: FirebaseOptions = FirebaseOptions.Builder()
            .setApplicationId("1:337880577447:android:df872fadb85e7c5333b282")
            .setApiKey("AIzaSyBwQvBrUzAwdwaAQIQY6kB77XM4kxf7tdQ")
            .setProjectId("grids-app-8a2b7")
            .setDatabaseUrl("https://grids-app-8a2b7-default-rtdb.europe-west1.firebasedatabase.app")
            .build()
        FirebaseApp.initializeApp(this, options)
    }

    fun getDbInstance(): FirebaseFirestore {
        return database
    }
}