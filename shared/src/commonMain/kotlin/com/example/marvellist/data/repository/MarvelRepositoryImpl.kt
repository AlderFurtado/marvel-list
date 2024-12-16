package com.example.marvellist.data.repository

import com.example.marvellist.data.datasource.MarvelApi

class MarvelRepositoryImpl(private val marvelApi: MarvelApi) : MarvelRepository{
    override suspend fun getCharacters(offset: Int, limit: Int)
        = marvelApi.getCharacters(offset,limit).data.results

    override suspend fun getCharacterById(id:String)
        = marvelApi.getCharacterById(id).data.results.first()

}