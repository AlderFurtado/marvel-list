package com.example.marvellist.data.model

data class Story(
    val available: Int,
    val collectionURI: String,
    val items: List<StoryItem>,
    val returned: Int
)
