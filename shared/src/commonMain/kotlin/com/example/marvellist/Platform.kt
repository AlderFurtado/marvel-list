package com.example.marvellist

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform