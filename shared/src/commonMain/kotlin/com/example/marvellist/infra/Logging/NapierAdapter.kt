package com.example.marvellist.infra.Logging

import io.github.aakira.napier.Napier

object NapierAdapter: Logging {
    override fun logDebug(message: String) {
        Napier.d(message)
    }

    override fun logError(message: String) {
        Napier.e(message)
    }

}