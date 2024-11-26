package com.example.marvellist.data.model

import kotlinx.serialization.Serializable

@Serializable
data class MarvelResponse(
    val code: Int,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHTML: String,
    val etag: String,
    val data: Data
)





