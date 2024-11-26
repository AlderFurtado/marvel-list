package com.example.marvellist.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Story(
    val available: Int,
    val collectionURI: String,
    val items: List<StoryItem>,
    val returned: Int
)
