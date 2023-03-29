package com.example.harrypotter.data.remote

import com.example.harrypotter.data.remote.models.CharacterModel
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
}