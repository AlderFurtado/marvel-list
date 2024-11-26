package com.example.marvellist.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Url(
    val type: String,
    val url: String
)
