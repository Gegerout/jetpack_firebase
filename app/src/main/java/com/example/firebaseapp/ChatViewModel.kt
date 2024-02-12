package com.example.firebaseapp

import android.text.Editable.Factory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.firebaseapp.data.ChatRepository
import kotlinx.coroutines.launch

class ChatViewModel(private val chatRepository: ChatRepository) : ViewModel() {
    companion object {
        val Factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val app = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as ChatApp)
                val chatRepository = app.container.chatRepository
                ChatViewModel(chatRepository)
            }
        }
    }

    fun sendMessage(message: String) {
        viewModelScope.launch {
            chatRepository.sendMessage(message)
        }
    }
}