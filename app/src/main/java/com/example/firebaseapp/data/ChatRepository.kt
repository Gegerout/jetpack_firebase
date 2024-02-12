package com.example.firebaseapp.data

import com.google.firebase.database.DatabaseReference

interface ChatRepository {
    suspend fun sendMessage(message: String)
}

class NetworkChatRepository(private val databaseRef: DatabaseReference) : ChatRepository {
    override suspend fun sendMessage(message: String) {
        databaseRef.child("message").setValue(message)
    }
}