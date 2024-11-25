package com.example.marvellist.data.model

data class Character(
    val id: Int,
    val name: String,
    val description: String,
    val modified: String,
    val thumbnail: Thumbnail,
    val resourceURI: String,
    val comics: Comic,
    val series: Serie,
    val events: Event,
    val urls: List<Url>
)