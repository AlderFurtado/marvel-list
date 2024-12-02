package com.example.marvellist.android.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

@Composable()
fun HomeScreen() {
    val options = mutableListOf("characters", "comics", "creators", "events", "series", "stories")
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    // Get half the width
    val halfScreenWidth = screenWidth / 2

    LazyVerticalGrid(
        columns = GridCells.FixedSize(size = (halfScreenWidth)),
        verticalArrangement = Arrangement.Center,
        horizontalArrangement = Arrangement.Center// Vertical spacing
    ) {
        items(options, key = { it }) {
            Card(
                modifier = Modifier
                    .height(300.dp)
                    .padding(vertical = 20.dp)
                ,
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
            ) {
                Box {
//                    Image(painter = , contentDescription = )
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(bottom = 4.dp),
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = it)
                    }
                }
            }
        }
    }
}

