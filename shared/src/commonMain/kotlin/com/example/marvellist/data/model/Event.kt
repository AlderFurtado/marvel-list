package com.example.marvellist.data.model

data class Event(
    val available: Int,
    val collectionURI: String,
    val items: List<EventItem>,
    val returned: Int
)
