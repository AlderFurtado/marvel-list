package com.example.marvellist.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Serie(
    val available: Int,
    val collectionURI: String,
    val items: List<SerieItem>,
    val returned: Int
)
