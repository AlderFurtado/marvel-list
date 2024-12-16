package com.example.marvellist.android.ui.detailscharacter

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun DetailsCharacterScreen(
    id: String,
    detailsCharacterViewModel: DetailsCharacterViewModel = viewModel()
) {
    val uiState = detailsCharacterViewModel.uiState.collectAsState()

    LaunchedEffect(true){
        detailsCharacterViewModel.getCharacter(id)
    }

    DetailsCharacterContent(character = uiState.value.character)
}