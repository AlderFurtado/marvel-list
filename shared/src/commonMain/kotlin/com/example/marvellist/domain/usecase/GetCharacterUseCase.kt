package com.example.marvellist.domain.usecase

import com.example.marvellist.data.model.Character
import com.example.marvellist.data.repository.MarvelRepository

class GetCharacterUseCase(private val repository: MarvelRepository) {
    //TODO create a mappers
    suspend fun invoke(id:String) = repository.getCharacterById(id)
}