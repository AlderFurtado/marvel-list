package com.example.marvellist.domain.usecase

import com.example.marvellist.data.repository.MarvelRepository
import com.example.marvellist.domain.mappers.CharacterToCharacterNameImage
import com.example.marvellist.domain.model.CharacterBasicInfo

class GetCharacterBasicInfoListUseCase(private val repository: MarvelRepository) {

    suspend fun invoke(offset: Int = OFFSET_DEFAULT, limit: Int = LIMIT_DEFAULT): List<CharacterBasicInfo> {
        return repository.getCharacter(offset, limit).map {
            CharacterToCharacterNameImage.transform(it)
        }
    }

    companion object {
        const val OFFSET_DEFAULT = 0
        const val LIMIT_DEFAULT = 100
    }
}
