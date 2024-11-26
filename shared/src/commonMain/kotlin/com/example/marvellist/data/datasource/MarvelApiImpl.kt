package com.example.marvellist.data.datasource

import com.example.marvellist.data.model.MarvelResponse
import com.example.marvellist.infra.Http.Http
import com.example.marvellist.infra.Logging.NapierAdapter
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse

class MarvelApiImpl(private val http: Http): MarvelApi {
    override suspend fun getCharacters(): MarvelResponse {
        val data = http.get<HttpResponse, () -> Unit>("https://gateway.marvel.com/v1/public/characters?ts=1&apikey=ec42ff12023878ab39a533cb3fcb5f44&hash=c2ca20873369bbbcdf9103d060ad390d&limit=100", {})
        val body: MarvelResponse = data.body()
        NapierAdapter.logDebug(body.toString())
        return body
    }
}