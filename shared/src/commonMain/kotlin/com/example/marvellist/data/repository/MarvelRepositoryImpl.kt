package com.example.marvellist.data.repository

import com.example.marvellist.data.datasource.MarvelApi
import com.example.marvellist.data.model.Character

class MarvelRepositoryImpl(private val marvelApi: MarvelApi) : MarvelRepository{
    override suspend fun getCharacters(offset: Int, limit: Int)
        = marvelApi.getCharacters(offset,limit).data.results

    override suspend fun getCharacterById(id:String)
        = marvelApi.getCharacterById(id).data.results.first()

}