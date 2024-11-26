package com.example.marvellist.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ComicItem(
    val resourceURI: String,
    val name: String
)