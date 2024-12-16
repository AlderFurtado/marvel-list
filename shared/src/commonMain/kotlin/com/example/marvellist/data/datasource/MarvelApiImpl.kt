package com.example.marvellist.data.datasource

import com.example.marvellist.BuildKonfig
import com.example.marvellist.data.model.MarvelResponse
import com.example.marvellist.infra.Http.Http
import com.example.marvellist.infra.Logging.NapierAdapter
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse

class MarvelApiImpl(private val http: Http) : MarvelApi {

    companion object {
        val publicKey = BuildKonfig.API_KEY_PUBLIC
        const val ts = 1
    }

    override suspend fun getCharacters(offset: Int, limit: Int): MarvelResponse {
        NapierAdapter.logDebug("getCharacters(offset=$offset, limit=$limit)")

        val url = stringUrlBuilder("v1/public/characters", offset, limit)

        NapierAdapter.logDebug("url = $url")
        val data = http.get<HttpResponse, () -> Unit>(url){}
        val body: MarvelResponse = data.body()
        NapierAdapter.logDebug(body.toString())
        return body.also {
            NapierAdapter.logDebug("")
        }
    }

    override suspend fun getCharacterById(id: String): MarvelResponse {
        NapierAdapter.logDebug("getCharacterById(id=$id)")

        val url = stringUrlBuilder("v1/public/characters/$id", 0, 1)

        NapierAdapter.logDebug("url = $url")
        val data = http.get<HttpResponse, () -> Unit>(url){}
        val body: MarvelResponse = data.body()
        NapierAdapter.logDebug(body.toString())
        return body.also {
            NapierAdapter.logDebug("")
        }
    }

    private fun stringUrlBuilder(url: String, offset: Int, limit: Int):String {
        val hash = BuildKonfig.MD5_KEY
        return "$url?ts=1&apikey=$publicKey&hash=$hash&limit=$limit&offset=$offset"
    }

}
