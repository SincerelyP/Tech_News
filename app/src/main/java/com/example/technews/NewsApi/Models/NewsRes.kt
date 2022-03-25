package com.example.technews.NewsApi.Models

import com.google.gson.annotations.SerializedName

data class NewsRes(
    @SerializedName("status") val status: String?= null,
    @SerializedName("code") val code: String? = null,
   @SerializedName("articles") val newsList: List<Article>? = null
)