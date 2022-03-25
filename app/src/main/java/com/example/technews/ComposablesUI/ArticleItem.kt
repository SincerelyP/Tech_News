package com.example.technews.ComposablesUI

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.SubcomposeAsyncImage
import com.example.technews.NewsApi.Models.Article
import com.example.technews.ViewModel.NewsViewModel
import com.example.technews.latoFamily
import com.example.technews.ui.theme.Blue100
import com.example.technews.ui.theme.White100


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ArticleLazyColumn(articlesList: List<Article>) {
    LazyColumn {


        items(articlesList) { item ->

            val uriHandler = LocalUriHandler.current

            Card(
                elevation = 5.dp,
                border = BorderStroke(
                    width = 2.dp,
                    brush = SolidColor(Blue100),
                ),


                modifier = Modifier
                    .combinedClickable(
                        onClick = { null },
                        onDoubleClick = {
                            uriHandler.openUri(item.url!!)
                        }
                    )
                    .padding(15.dp)
                    .background(
                        Color.Black
                    ),
                backgroundColor = Color.Transparent
            ) {
                Column(
                    modifier = Modifier.padding(8.dp),

                    ) {

                    Card(
                        modifier = Modifier

                            .fillMaxWidth()
                            .height(180.dp),

                        ) {
                        SubcomposeAsyncImage(
                            model = item.urlToImage,
                            loading = {
                                CircularProgressIndicator()
                            },
                            contentDescription = null,
                            contentScale = ContentScale.FillBounds
                        )

                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = item.title,
                        fontSize = 25.sp,
                        fontFamily = latoFamily,
                        fontWeight = FontWeight.Black,
                        color = White100
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "",
                        fontSize = 12.5.sp,
                        fontFamily = latoFamily,
                        fontWeight = FontWeight.Normal,
                        color = White100
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()

                    ) {

                        Text(
                            text = item.publishedAt.substring(0, 10),
                            color = White100,
                            fontFamily = latoFamily,
                            fontWeight = FontWeight.Black
                        )

                    }


                }
            }

        }
    }
}

@Composable
fun ArticleLazy(
    viewModel: NewsViewModel = hiltViewModel()
) {


    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ) {
        Column {

            val newsFeed by viewModel.getNews().observeAsState(initial = emptyList())

            TopAppBar()
            Divider(color = Blue100, thickness = 2.dp)
            SearchBar()
            ArticleLazyColumn(newsFeed)

        }

    }

}











