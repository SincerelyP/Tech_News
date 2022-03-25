package com.example.technews.DI

import com.example.technews.NewsApi.NewsApi
import com.example.technews.NewsApi.util.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NewsInstance {
    @Provides
    @Named("BaseUrl")
    fun provideBaseUrl() = BASE_URL.toHttpUrl()

    @Singleton
    @Provides

    fun provRetrofit(
        @Named("BaseUrl")baseUrl: HttpUrl):Retrofit{
      return  Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun newsObject(retrofit: Retrofit): NewsApi =
        retrofit.create(NewsApi::class.java)




}