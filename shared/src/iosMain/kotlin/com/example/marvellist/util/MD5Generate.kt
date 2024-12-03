package com.example.marvellist.util
import kotlinx.cinterop.*
import platform.CoreCrypto.CC_MD5

actual object MD5Generate {
    @OptIn(ExperimentalForeignApi::class)
    actual fun invoke(input:String): String {
        val data = input.encodeToByteArray()
        val digest = UByteArray(16)
        data.usePinned { pinned ->
            CC_MD5(pinned.addressOf(0), data.size.toUInt(), digest.refTo(0))
        }
        return digest.joinToString("")
    }

}