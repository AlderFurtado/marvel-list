package com.example.marvellist.data.datasource

import com.example.marvellist.infra.Http.HttpAdapter
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertTrue

class MarvelApiImplTest {

    private lateinit var marvelApiImpl: MarvelApiImpl
    private lateinit var httpAdapter: HttpAdapter

    @Test
    fun getCharacters() = runBlocking{
        httpAdapter = HttpAdapter("https://gateway.marvel.com")
        marvelApiImpl = MarvelApiImpl(httpAdapter)
        val data = marvelApiImpl.getCharacters(0,100)
        assertTrue(true)
    }
}