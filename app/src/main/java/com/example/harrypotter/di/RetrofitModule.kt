package com.example.harrypotter.di

import com.example.harrypotter.data.remote.HarryPoterAPI
import com.example.harrypotter.util.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/*
Retrofit is a library that simplifies the process of making
HTTP requests from an Android Application.
Overall Retrofit simplifies the process of making network requests from our Android App
 */
@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    @Singleton
    @Provides
    //providesRetrofit
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    //providesHarryPoterAPI
    fun providesHarryPoter(retrofit: Retrofit): HarryPoterAPI{
        return retrofit.create(HarryPoterAPI::class.java)
    }
}