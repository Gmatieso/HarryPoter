package com.example.harrypotter.data.remote

import com.example.harrypotter.data.remote.models.CharacterModel
import com.example.harrypotter.data.remote.models.SpecificCharacterModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HarryPotterService @Inject constructor(private val harryPoterAPI: HarryPoterAPI) {

    //retrieve list of CharacterModel objects from an API using Retrofit library and coroutine's
    suspend fun getCharacter(): List<CharacterModel> {
        return withContext(Dispatchers.IO) {
            val characters = harryPoterAPI.getCharacter()
            characters.body()?: emptyList()
        }
    }
    //retrieve a specificCharacterModel object by its house from an API using Retrofit and Coroutine's
    suspend fun getCharacterById(house: String): SpecificCharacterModel {
        return withContext(Dispatchers.IO) {
            val characters = harryPoterAPI.getCharacterById(house)
            characters.body()!!
        }
    }
}