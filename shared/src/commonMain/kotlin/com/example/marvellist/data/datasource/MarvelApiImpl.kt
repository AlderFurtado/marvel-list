package com.example.marvellist.data.datasource

import com.example.marvellist.BuildKonfig
import com.example.marvellist.data.model.MarvelResponse
import com.example.marvellist.infra.http.Http
import com.example.marvellist.infra.logging.NapierAdapter
import com.example.marvellist.util.MD5Generate
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse

class MarvelApiImpl(private val http: Http) : MarvelApi {

    companion object {
        val publicKey = BuildKonfig.API_KEY_PUBLIC
        val privateKey = BuildKonfig.API_KEY_PRIVATE
        const val ts = 1
    }

    override suspend fun getCharacters(offset: Int, limit: Int): MarvelResponse {
        val data = http.get<HttpResponse, () -> Unit>(stringUrlBuilder("v1/public/characters", offset, limit), {})
        val body: MarvelResponse = data.body()
        NapierAdapter.logDebug(body.toString())
        return body
    }

    private fun stringUrlBuilder(url: String, offset: Int, limit: Int):String {
        val hash = generateMD5Hash()
        return "$url?ts=1&apikey=$publicKey&hash=$hash&limit=$limit&offset=$offset"
    }
    private fun generateMD5Hash():String {
        val input = "$ts$privateKey$publicKey"
        return MD5Generate.invoke(input)
    }
}
