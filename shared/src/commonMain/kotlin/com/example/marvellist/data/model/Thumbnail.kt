package com.example.marvellist.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Thumbnail(
    val path: String,
    val extension: String
)
