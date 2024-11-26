package com.example.marvellist.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Comic(
    val available: Int,
    val collectionURI: String,
    val items: List<ComicItem>,
    val returned: Int
)
