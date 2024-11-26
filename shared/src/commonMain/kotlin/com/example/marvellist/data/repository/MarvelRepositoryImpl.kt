package com.example.marvellist.data.repository

import com.example.marvellist.data.datasource.MarvelApi
import com.example.marvellist.data.model.Character

class MarvelRepositoryImpl(private val marvelApi: MarvelApi) : MarvelRepository{
    override suspend fun getCharacter(): List<Character> = marvelApi.getCharacters().data.results

}