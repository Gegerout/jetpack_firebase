package com.example.firebaseapp

import android.app.Application
import com.example.firebaseapp.data.AppContainer
import com.example.firebaseapp.data.DefaultAppContainer

class ChatApp : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}