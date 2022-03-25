package com.example.technews.NewsApi

import com.example.technews.NewsApi.Models.NewsRes
import com.example.technews.NewsApi.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("top-headlines?category=technology&apiKey=$API_KEY")

    // Function For Network Req.
    suspend fun getTechNews(
        @Query("country")
        countryCode: String ,
    ): Response<NewsRes>


}