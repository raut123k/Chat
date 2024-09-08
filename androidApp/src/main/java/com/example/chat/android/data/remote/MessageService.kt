package com.example.chat.android.data.remote

import com.example.chat.android.domain.model.Message

interface MessageService {
    suspend fun getAllMessages(): List<Message>

    companion object{
        const val BASE_URL  = "http://192.168.0.109:8082"
    }
    sealed class Endpoints(val url: String){
        object GetAllMessages: Endpoints("$BASE_URL/messages")
    }
}