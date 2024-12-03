package com.example.marvellist.android.ui.listcharacter.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.R
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.marvellist.domain.model.CharacterBasicInfo

@Composable
fun CardCharacter(characterBasicInfo: CharacterBasicInfo){
    val imageUrlCompleted =
        "${characterBasicInfo.imageUrl}/portrait_xlarge.jpg".replace("http", "https")
    val marvelRed = Color(red = 211 / 255f, green = 47 / 255f, blue = 47 / 255f)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .padding(8.dp)
    ) {

        Log.d("IMAGE_CHARACTER", imageUrlCompleted)
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
                .size(160.dp)
                .clip(RoundedCornerShape(16.dp))

        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 6.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            val description = if (characterBasicInfo.description.toString().isEmpty()
                    .not()
            ) characterBasicInfo.description as String else "N/A"
            val nameMaxLines = if(characterBasicInfo.description?.isBlank() as Boolean) 2 else 1
            Column {
                Text(
                    text = "created: ${characterBasicInfo.lastModified}",
                    maxLines = 3,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                Text(
                    text = characterBasicInfo.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    maxLines = nameMaxLines
                )
                Text(
                    text = description,
                    maxLines = 3,
                    fontSize = 14.sp,
                    overflow = TextOverflow.Ellipsis,
                    lineHeight = 16.sp
                )
            }
            Row(
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier.fillMaxSize()
            ) {
                Button(onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(4.dp),
                    modifier = Modifier
                        .padding(4.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = marvelRed)
                ) {
                    Text(text = "More")
                }
            }

        }
    }
}