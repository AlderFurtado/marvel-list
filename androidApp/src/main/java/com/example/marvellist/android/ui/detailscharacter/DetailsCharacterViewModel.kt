package com.example.marvellist.android.ui.detailscharacter

import androidx.lifecycle.ViewModel
import com.example.marvellist.data.model.Character
import com.example.marvellist.factory.Factories
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DetailsCharacterViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(DetailsCharacterUiState())
    val uiState: StateFlow<DetailsCharacterUiState> = _uiState.asStateFlow()

    suspend fun getCharacter(id: String){
        val character = requestGetCharacter(id)
        _uiState.update {
            it.copy(character = character)
        }
    }

    private suspend  fun requestGetCharacter(id:String): Character
        = Factories.getCharacterUseCase().invoke(id)
}