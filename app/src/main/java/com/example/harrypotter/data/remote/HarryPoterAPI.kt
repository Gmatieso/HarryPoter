package com.example.harrypotter.data.remote

import com.example.harrypotter.data.remote.models.CharacterModel
import com.example.harrypotter.data.remote.models.SpecificCharacterModel
import com.example.harrypotter.util.Constants.Companion.CHARACTERS_ENDPOINT
import com.example.harrypotter.util.Constants.Companion.CHARACTERS_ID_ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


/*
Type of Declaration that defines a set of
methods and properties that a class can implement
i.e a contract/set of requirements that a class must adhere to
 */

interface HarryPoterAPI {
    //retrofit2.http GET
    @GET(CHARACTERS_ENDPOINT)
    suspend fun getCharacter(): Response<List<CharacterModel>>  //Coroutine call to a suspend function for network Request

    @GET(CHARACTERS_ID_ENDPOINT)
    suspend fun getCharacterById(@Query(value = "house") house: String): Response<SpecificCharacterModel>
}