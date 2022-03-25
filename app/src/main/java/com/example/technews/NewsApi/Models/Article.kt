package com.example.technews.NewsApi.Models

import com.google.gson.annotations.SerializedName


data class Article(
    @SerializedName("author") var author: String,
    @SerializedName("description") var description: String? = null,
    @SerializedName("publishedAt") var publishedAt: String,
    @SerializedName("title") var title: String,
    @SerializedName("url") var url: String? = null,
    @SerializedName("urlToImage") var urlToImage: String? = null
)

