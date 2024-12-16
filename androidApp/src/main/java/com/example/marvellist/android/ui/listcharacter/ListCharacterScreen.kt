package com.example.marvellist.android.ui.listcharacter


import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ListCharacterScreen(
    viewModel: ListCharacterViewModel = viewModel(),
    navigationToDetailsScreen: (id:String) -> Unit,
){
    val uiState = viewModel.uiState.collectAsState()

    LaunchedEffect(true){
        viewModel.getCharacterNameImageList()
    }

    val listState = rememberLazyListState()

    LaunchedEffect(listState) {
        snapshotFlow { listState.layoutInfo.visibleItemsInfo }
            .collect { visibleItems ->
                val lastVisibleItem = visibleItems.lastOrNull() ?: return@collect
                if (lastVisibleItem.index == uiState.value.items.size - 1) {
                    viewModel.loadMoreItems()
                }
            }
    }

    ListCharacterContent(
        items = uiState.value.items,
        isLoading = uiState.value.isLoading,
        isLoadingMoreItems = uiState.value.isLoadingMoreItems,
        listState = listState,
        navigationToDetailsScreen
    )
}
