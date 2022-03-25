package com.example.technews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.technews.ComposablesUI.ArticleLazy
import com.example.technews.ViewModel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = hiltViewModel<NewsViewModel>()

            ArticleLazy(viewModel)

        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

}