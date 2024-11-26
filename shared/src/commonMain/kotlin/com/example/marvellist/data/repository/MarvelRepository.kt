package com.example.marvellist.data.repository

import com.example.marvellist.data.model.Character

interface MarvelRepository {

    suspend fun getCharacter(): List<Character>
}