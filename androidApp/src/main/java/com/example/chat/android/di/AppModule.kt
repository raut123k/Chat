package com.example.chat.android.di


import com.example.chat.android.data.remote.ChatSocketService
import com.example.chat.android.data.remote.ChatSocketServiceImpl
import com.example.chat.android.data.remote.MessageService
import com.example.chat.android.data.remote.MessageServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.Logging
import io.ktor.client.features.websocket.WebSockets
import kotlinx.serialization.json.JsonConfiguration
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient{
        return HttpClient(CIO){
            install(Logging)
            install(WebSockets)
            install(JsonFeature){
                serializer = KotlinxSerializer()
            }
        }
    }

    @Provides
    @Singleton
    fun provideMessageService(client: HttpClient): MessageService{
        return MessageServiceImpl(client)
    }

    @Provides
    @Singleton
    fun provideChatSocketService(client: HttpClient): ChatSocketService{
        return ChatSocketServiceImpl(client)
    }
}