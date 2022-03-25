package com.example.technews.DI

import com.example.technews.NewsApi.NewsApi
import com.example.technews.Repository.NewsRepository
import com.example.technews.Repository.NewsRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun providersNewsRepository(provider: NewsApi): NewsRepository =
        NewsRepositoryImp(provider)
}
