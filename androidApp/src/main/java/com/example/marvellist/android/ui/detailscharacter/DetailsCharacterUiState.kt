package com.example.marvellist.android.ui.detailscharacter

import com.example.marvellist.data.model.Character

data class DetailsCharacterUiState(
    val character: Character? = null,
    val isLoading: Boolean = true,
    val hasError: Boolean = false,
    val error: String? = ""
)