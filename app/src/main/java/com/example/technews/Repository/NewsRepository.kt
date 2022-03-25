package com.example.technews.Repository

import com.example.technews.NewsApi.Models.Article
import com.example.technews.NewsApi.NewsApi
import javax.inject.Inject


interface NewsRepository {
    suspend fun getNews(country: String): List<Article>
    fun getArticle (title: String): Article
}

class NewsRepositoryImp @Inject constructor(
    private val newsApi: NewsApi
): NewsRepository {

    private var news: List<Article> = emptyList()

    override suspend fun getNews(country: String): List<Article> {
        val apiResponse = newsApi.getTechNews(country).body()
        if (apiResponse?.status == "error") {
            when (apiResponse.code) {
                "apiKeyMissing" -> throw MissingApiKeyException()
                "apiKeyInvalid" -> throw ApiKeyInvalidException()
                else -> throw Exception()
            }
        }
        news = apiResponse?.newsList ?: emptyList()
        return news
    }

    override fun getArticle(title: String): Article =
        news.first { it.title == title }

}

class MissingApiKeyException : java.lang.Exception()
class ApiKeyInvalidException : java.lang.Exception()