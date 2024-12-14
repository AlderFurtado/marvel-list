package com.example.marvellist.android.ui.listcharacter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.marvellist.android.ui.listcharacter.components.CardCharacter
import com.example.marvellist.domain.model.CharacterBasicInfo

@Composable
fun ListCharacterContent(
    items: List<CharacterBasicInfo>,
    isLoading: Boolean,
    isLoadingMoreItems: Boolean,
    listState: LazyListState
) {
    Column {
        Text(
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier.padding(12.dp),
            text = "Characters"
        )
        if(isLoading) {
            CircularProgressIndicator(modifier = Modifier.padding(24.dp))
        }
        LazyColumn(
            state = listState,
        ) {
            items(items, key = { it.name }) {
                CardCharacter(it)
            }

            if (isLoadingMoreItems) {
                item {
                    CircularProgressIndicator(modifier = Modifier.padding(16.dp))
                }
            }
        }
    }
}