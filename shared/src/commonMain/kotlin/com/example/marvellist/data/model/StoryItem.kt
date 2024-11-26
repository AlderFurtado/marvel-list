package com.example.marvellist.data.model

import kotlinx.serialization.Serializable

@Serializable
data class StoryItem(
    val resourceURI: String,
    val name: String,
    val type: String
)

