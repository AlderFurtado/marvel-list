package com.example.marvellist.infra.Http

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.serialization.kotlinx.json.json

@Suppress("UNCHECKED_CAST")
class HttpAdapter: Http {
    private val client = HttpClient() {
        install(ContentNegotiation){
            json()
        }
    }

    override suspend fun <HttpResponse, V> get(url: String, options: V): HttpResponse {
        return client.get(url,options as HttpRequestBuilder.() -> Unit) as HttpResponse
    }

    override suspend fun  <HttpResponse, V> post(url: String, options: V): HttpResponse {
        return client.post(url,options as HttpRequestBuilder.() -> Unit) as HttpResponse
    }

    override suspend fun <HttpResponse, V> put(url: String, options: V): HttpResponse {
        return client.put(url,options as HttpRequestBuilder.() -> Unit) as HttpResponse
    }

    override suspend fun <HttpResponse, V> delete(url: String, options: V): HttpResponse {
        return client.delete(url,options as HttpRequestBuilder.() -> Unit) as HttpResponse
    }

}