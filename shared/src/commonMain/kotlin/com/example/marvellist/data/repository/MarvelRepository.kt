package com.example.marvellist.data.repository

import com.example.marvellist.data.model.Character

interface MarvelRepository {

    suspend fun getCharacters(offset: Int, limit: Int): List<Character>
    suspend fun getCharacterById(id:String): Character
}