package com.example.marvellist.data.model

data class Serie(
    val available: Int,
    val collectionURI: String,
    val items: List<SerieItem>,
    val returned: Int
)
