package com.example.technews.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.technews.NewsApi.Models.Article
import com.example.technews.Repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(val newsRepository: NewsRepository): ViewModel() {

    private val _news = MutableLiveData<List<Article>>()

    fun getNews() : LiveData<List<Article>> {
        viewModelScope.launch(Dispatchers.IO) {
            val news = newsRepository.getNews("za")
            _news.postValue(news)
        }
        return _news
    }

}

