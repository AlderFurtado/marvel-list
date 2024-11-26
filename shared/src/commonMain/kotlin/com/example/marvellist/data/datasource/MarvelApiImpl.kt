package com.example.marvellist.data.datasource

import com.example.marvellist.data.model.MarvelResponse
import com.example.marvellist.infra.Http.Http
import com.example.marvellist.infra.Logging.NapierAdapter
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse

class MarvelApiImpl(private val http: Http): MarvelApi {
    override suspend fun getCharacters(): MarvelResponse {
        val data = http.get<HttpResponse, () -> Unit>("", {})
        val body: MarvelResponse = data.body()
        NapierAdapter.logDebug(body.toString())
        return body
    }
}