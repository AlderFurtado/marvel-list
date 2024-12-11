package com.example.marvellist.android.ui.listcharacter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.marvellist.android.ui.listcharacter.components.CardCharacter
import com.example.marvellist.domain.model.CharacterBasicInfo
import com.example.marvellist.factory.Factories

@Composable
fun ListCharacterScreen(){
    val cniList  = remember { mutableStateListOf<CharacterBasicInfo>() }
    LaunchedEffect(true){
        loadMoreItems(cniList,0,100)
    }
    val listState = rememberLazyListState()
    var isLoading = remember { mutableStateOf(false) }
    var offset = remember { mutableStateOf(0) }
    val limit = 100
    val isPopular = remember {
        mutableStateOf(false)
    }

    LaunchedEffect(listState) {
        snapshotFlow { listState.layoutInfo.visibleItemsInfo }
            .collect { visibleItems ->
                val lastVisibleItem = visibleItems.lastOrNull() ?: return@collect
                if (lastVisibleItem.index == cniList.size - 1 && !isLoading.value) {
                    offset.value = (offset.value + limit)
                    isLoading.value = true
                    loadMoreItems(cniList, offset.value, limit)
                    isLoading.value = false

                }
            }
    }

    Column {
        LazyColumn(
            state = listState,
        ) {
            items(cniList, key = { it.name }) {
                CardCharacter(it)
            }

            if (isLoading.value) {
                item {
                    CircularProgressIndicator(modifier = Modifier.padding(16.dp))
                }
            }
        }
    }
}

private suspend fun loadMoreItems(items: MutableList<CharacterBasicInfo>,offset: Int, limit:Int) {
    getCharacterNameImageList(offset,limit).map {
        items.add(it)
    }
}

private suspend fun getCharacterNameImageList(offset: Int, limit:Int): List<CharacterBasicInfo>{
    return Factories.getCharacterBasicInfoListUseCase().invoke(offset,limit)
}