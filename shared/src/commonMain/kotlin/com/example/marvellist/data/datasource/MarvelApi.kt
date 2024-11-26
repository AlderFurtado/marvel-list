package com.example.marvellist.data.datasource

import com.example.marvellist.data.model.MarvelResponse

interface MarvelApi {
    suspend fun getCharacters(): MarvelResponse
}