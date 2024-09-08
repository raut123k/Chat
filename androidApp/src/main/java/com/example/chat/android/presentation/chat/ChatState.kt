package com.example.chat.android.presentation.chat
import com.example.chat.android.domain.model.Message

data class ChatState(
    val messages: List<Message> = emptyList(),
    val isLoading: Boolean = false
)