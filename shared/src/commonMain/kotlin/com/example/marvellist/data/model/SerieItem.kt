package com.example.marvellist.data.model

import kotlinx.serialization.Serializable

@Serializable
data class SerieItem(
    val resourceURI: String,
    val name: String
)
