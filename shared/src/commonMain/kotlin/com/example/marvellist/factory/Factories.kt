package com.example.marvellist.factory

import com.example.marvellist.data.datasource.MarvelApiImpl
import com.example.marvellist.data.repository.MarvelRepositoryImpl
import com.example.marvellist.domain.usecase.GetCharacterBasicInfoListUseCase
import com.example.marvellist.domain.usecase.GetCharacterUseCase
import com.example.marvellist.infra.Http.HttpAdapter

object Factories {

    private fun getHttp() = HttpAdapter("https://gateway.marvel.com")

    private fun getMarvelApi() = MarvelApiImpl(getHttp())
    private fun getMarvelRepository() = MarvelRepositoryImpl(getMarvelApi())

    fun getCharacterUseCase() = GetCharacterUseCase(getMarvelRepository())

    fun getCharacterBasicInfoListUseCase() = GetCharacterBasicInfoListUseCase(getMarvelRepository())
}