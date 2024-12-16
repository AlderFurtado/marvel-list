package com.example.marvellist.domain.mappers

import com.example.marvellist.data.model.Character
import com.example.marvellist.domain.model.CharacterBasicInfo

object CharacterToCharacterNameImage : Mapper<Character, CharacterBasicInfo> {
    override fun transform(input: Character): CharacterBasicInfo = CharacterBasicInfo(
        id = input.id,
        name = input.name,
        imageUrl = input.thumbnail.path,
        description = input.description,
        lastModified = input.modified.subSequence(0,10).toString(),
        numberOfEvents = input.events.available,
        numberOfComics = input.comics.available,
        numberOfSeries = input.series.available,
        numberOfStories = input.stories.available,
    )
}

interface Mapper<I, O> {
    fun transform(input: I): O
}
