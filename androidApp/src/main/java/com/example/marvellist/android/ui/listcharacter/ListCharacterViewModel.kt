package com.example.marvellist.android.ui.listcharacter

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.marvellist.domain.model.CharacterBasicInfo
import com.example.marvellist.factory.Factories
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ListCharacterViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(ListCharacterUiState())
    val uiState: StateFlow<ListCharacterUiState> = _uiState.asStateFlow()

    suspend fun loadMoreItems() {
        if(_uiState.value.isLoadingMoreItems) return
        _uiState.update {
            it.copy(offset = it.offset + LIMIT, isLoadingMoreItems = true)
        }
        val listTemp = _uiState.value.items.toMutableList()
        requestGetCharacterNameImageList(_uiState.value.offset).map {
            listTemp.add(it)
        }
        _uiState.update {
            it.copy(items = listTemp, isLoadingMoreItems = false)
        }
    }

    suspend fun getCharacterNameImageList(){
        Log.d("getCharacterNameImageList", "true")
        val listTemp = mutableListOf<CharacterBasicInfo>()
        requestGetCharacterNameImageList(OFFSET_INIT).map {
            listTemp.add(it)
        }
        _uiState.update {
            it.copy(items = listTemp, isLoading = false)
        }
    }
    private suspend fun requestGetCharacterNameImageList(offset: Int): List<CharacterBasicInfo>{
        return Factories.getCharacterBasicInfoListUseCase().invoke(offset, LIMIT)
    }

    companion object {
        const val LIMIT = 100
        const val OFFSET_INIT = 0
    }
}