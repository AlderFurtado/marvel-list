package com.example.marvellist.data.repository

import com.example.marvellist.data.datasource.MarvelApi
import com.example.marvellist.data.model.Character

class MarvelRepositoryImpl(private val marvelApi: MarvelApi) : MarvelRepository{
    override suspend fun getCharacter(offset: Int, limit: Int): List<Character>
        = marvelApi.getCharacters(offset,limit).data.results

}