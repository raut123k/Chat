package com.example.chat

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform