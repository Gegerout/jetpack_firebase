package com.example.firebaseapp.data

import com.google.firebase.Firebase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database

interface AppContainer {
    val chatRepository: ChatRepository
}

class DefaultAppContainer : AppContainer {
    private val database: DatabaseReference by lazy {
        Firebase.database.getReference("chat")
    }

    override val chatRepository: ChatRepository by lazy {
        NetworkChatRepository(database)
    }
}