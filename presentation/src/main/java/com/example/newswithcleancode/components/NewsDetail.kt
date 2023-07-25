package com.example.newswithcleancode.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.newswithcleancode.R
import com.example.newswithcleancode.model.News
import com.example.newswithcleancode.ui.theme.Calisto
import com.example.newswithcleancode.ui.theme.RockWell
import com.example.newswithcleancode.utils.extractDate

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun NewsDetail(
    data: News,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(data.title, style = MaterialTheme.typography.titleLarge)

        data.image?.let {
            GlideImage(
                model = it,
                contentDescription = null
            )
        }

        Row(Modifier.fillMaxWidth()) {
            Text(data.published.extractDate())
            Text(data.author)
        }

        Text(data.description)
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)
@Composable
fun DetailScreen(
    data: News,
    modifier: Modifier = Modifier,
    onBack: () -> Unit
) {
    Column(modifier) {
        TopAppBar(
            title = {},
            navigationIcon = {
                IconButton(onClick = onBack) {
                    Icon(painterResource(R.drawable.baseline_arrow_back_ios_24), null)
                }
            }
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .border(width = 1.dp, color = Color.Black, shape = RectangleShape)
                .padding(12.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Text(
                    text = data.title,
                    lineHeight = 28.sp,
                    fontFamily = RockWell,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    modifier = Modifier.padding(top = 8.dp),
                    text = data.published,
                    lineHeight = 18.sp,
                    fontSize = 15.sp,
                    color = Color.Gray,
                    fontFamily = Calisto
                )

                Text(
                    modifier = Modifier.padding(top = 8.dp),
                    text = data.author.takeIf { x->x.isNotBlank() } ?: "----",
                    color = Color.Black,
                    lineHeight = 18.sp,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = Calisto
                )

                data.image?.let {
                    GlideImage(
                        model = it,
                        contentDescription = null
                    )
                }

                Spacer(Modifier.height(16.dp))

                Text(
                    modifier = Modifier.padding(top = 8.dp),
                    text = data.description,
                    color = Color.Black,
                    lineHeight = 22.sp,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = Calisto
                )
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                shape = RectangleShape,
                onClick = { }
            ) {
                Text(
                    text = "Read the full article",
                    fontFamily = RockWell,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun NewsDetailPreview() {
    NewsDetail(data = News(
        author = "you",
        category = listOf(),
        description = """
            why why why why why why why why why why why why why 
            why why why why why why why why why why why why why 
            why why why why why why why why why why why why why 
            why why why why why why why why why why why why why 
            why why why why why why why why why why why why why 
            why why why why why why why why why why why why why 
            why why why why why why why why why why why why why""".trimIndent(),
        id = "",
        image = null, // GlideImage currently doesn't support preview.
        language = "en",
        published = "2023-07-12 21:20:13 +0000",
        title = "A Very Breaking News That Absolutely Nobody Cares",
        url = "https://www.google.com"
    ))
}