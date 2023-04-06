package com.example.harrypotter.di

import com.example.harrypotter.core.presentation.util.Constants.Companion.BASE_URL
import com.example.harrypotter.core.data.HarryPotterApi
import com.example.harrypotter.core.data.MyInterceptor
import com.example.harrypotter.core.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/*
Retrofit is a library that simplifies the process of making
HTTP requests from an Android Application.
Overall Retrofit simplifies the process of making network requests from our Android App
 */
@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient
        .Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(MyInterceptor())
        .build()


    @Singleton
    @Provides
    //providesRetrofit
    fun provideRetrofit(
        client: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun provideHarryPotterApi(retrofit: Retrofit): HarryPotterApi =
        retrofit.create(HarryPotterApi::class.java)

    @Provides
    @Singleton
    fun provideHarryPotterUseCases(
        harryPotterApi: HarryPotterApi
    ) = HarryPotterUseCases(
        getCharacters = GetCharacters(harryPotterApi),
        getStudents = GetStudents(harryPotterApi),
        getAllStaff = GetAllStaff(harryPotterApi),
        getSpells = GetSpells(harryPotterApi),
        getCharacter = GetCharacter(harryPotterApi),
        getCharactersInHouse = GetCharactersInHouse(harryPotterApi)
    )
}