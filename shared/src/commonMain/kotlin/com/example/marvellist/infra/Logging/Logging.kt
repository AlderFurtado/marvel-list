package com.example.marvellist.infra.Logging

interface Logging {

    fun logDebug(message: String)

    fun logError(message: String)
}