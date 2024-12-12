package com.example.marvellist.domain.usecase

import com.example.marvellist.data.model.Character
import com.example.marvellist.data.repository.MarvelRepository

class GetCharacterUseCase(private val repository: MarvelRepository) {
     suspend fun invoke(offset: Int, limit: Int): List<Character>{
         return repository.getCharacter(offset,limit)
     }
}