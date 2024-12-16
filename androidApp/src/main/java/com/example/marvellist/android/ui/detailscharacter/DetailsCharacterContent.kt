package com.example.marvellist.android.ui.detailscharacter

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import androidx.core.R
import com.example.marvellist.data.model.Character

@Composable
fun DetailsCharacterContent(
    character: Character?
) {
    character?.let {
        val imageUrlCompleted =
            "${character.thumbnail.path}/portrait_fantastic.jpg".replace("http", "https")
        Column {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageUrlCompleted)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.ic_call_answer_video),
                error = painterResource(id = R.drawable.ic_call_decline_low),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = character.name,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(text = "Bio",
                    fontSize = 13.sp,
                    color = Color.Gray
                )
                Text(text = character.description,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W300,
                    lineHeight = 18.sp
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth()
                ){
                    Text(text = "${character.comics.available} comics")
                    Text(text = "${character.stories.available} stories")
                    Text(text = "${character.events.available} events")
                    Text(text = "${character.series.available} series")
                }
                Divider()
//                Text(text = "Comics")
////                LazyRow(){
////                    items(character.comics.items, key = {it.name}){
////                        val imageUrlCompletedR =
////                            "${it.resourceURI}/portrait_fantastic.jpg".replace("http", "https")
////                        Log.d("imageUrlCompleted",imageUrlCompletedR)
////
////                        AsyncImage(
////                            model = ImageRequest.Builder(LocalContext.current)
////                                .data(imageUrlCompletedR)
////                                .crossfade(true)
////                                .build(),
////                            placeholder = painterResource(R.drawable.ic_call_answer_video),
////                            error = painterResource(id = R.drawable.ic_call_decline_low),
////                            contentDescription = "",
////                            contentScale = ContentScale.Crop,
////                            modifier = Modifier
////                                .fillMaxWidth()
////                                .height(300.dp)
////                        )
////
////                    }
////                }
            }


        }

    }


}