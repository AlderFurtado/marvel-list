package com.example.marvellist.data.model

data class Comic(
    val available: Int,
    val collectionURI: String,
    val items: List<ComicItem>,
    val returned: Int
)
