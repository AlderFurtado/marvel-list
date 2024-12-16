package com.example.marvellist.android.navigation

enum class Route(val value: String, val argument: String?) {
    HOME_SCREEN("HOME_SCREEN", null),
    CHARACTER_LIST_SCREEN("CHARACTER_LIST_SCREEN", null),
    CHARACTER_DETAILS("CHARACTER_DETAILS", "id")
}