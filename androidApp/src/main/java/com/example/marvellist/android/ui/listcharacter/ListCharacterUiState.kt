package com.example.marvellist.android.ui.listcharacter

import com.example.marvellist.domain.model.CharacterBasicInfo

data class ListCharacterUiState(
    val items: List<CharacterBasicInfo> = mutableListOf(),
    val isLoading: Boolean = true,
    val isLoadingMoreItems: Boolean = false,
    val offset: Int = 0
)