package com.example.marvellist.util

expect object MD5Generate {
    fun invoke(input:String): String
}