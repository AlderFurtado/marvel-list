package com.example.marvellist.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Event(
    val available: Int,
    val collectionURI: String,
    val items: List<EventItem>,
    val returned: Int
)
