package com.example.chat.android.data.remote

import com.example.chat.android.data.remote.dto.MessageDto
import com.example.chat.android.domain.model.Message
import io.ktor.client.*
import io.ktor.client.request.get


class MessageServiceImpl(
    private val client: HttpClient
): MessageService {
    override suspend fun getAllMessages(): List<Message> {
        return try{
            client.get<List<MessageDto>>(MessageService.Endpoints.GetAllMessages.url ).map {
                it.toMessage()
            }
        }catch (e: Exception){
            emptyList()
        }
    }
}