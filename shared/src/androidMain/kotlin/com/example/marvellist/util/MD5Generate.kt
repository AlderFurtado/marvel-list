package com.example.marvellist.util

import java.math.BigInteger
import java.security.MessageDigest

actual object MD5Generate {
    actual fun invoke(input:String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }


}