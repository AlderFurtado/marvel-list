package com.example.marvellist.domain.model

data class CharacterBasicInfo(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val description: String?,
    val lastModified: String,
    val numberOfEvents: Int,
    val numberOfComics: Int,
    val numberOfSeries: Int,
    val numberOfStories: Int,
)
