package com.example.marvellist.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Character(
    val id: Int,
    val name: String,
    val description: String,
    val modified: String,
    val thumbnail: Thumbnail,
    val resourceURI: String,
    val comics: Comic,
    val series: Serie,
    val stories: Story,
    val events: Event,
    val urls: List<Url>
)