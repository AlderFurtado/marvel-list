package com.example.marvellist.infra.Http

interface Http{
    suspend fun <T , V> get(url: String, options:V): T
    suspend fun <T, V> post(url: String,options:V): T
    suspend fun <T, V> put(url: String,options:V): T
    suspend fun <T, V> delete(url: String,options:V): T
}