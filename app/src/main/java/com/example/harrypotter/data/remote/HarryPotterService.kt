package com.example.harrypotter.data.remote

import android.util.Log
import com.example.harrypotter.data.remote.models.CharacterModel
import com.example.harrypotter.data.remote.models.SpecificCharacterModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HarryPotterService @Inject constructor(private val harryPoterAPI: HarryPoterAPI) {

    //retrieve list of CharacterModel objects from an API using Retrofit library and coroutine's
    companion object {
        const val TAG = "HarryPotterService"
    }
    suspend fun getCharacter(): List<CharacterModel> {
       return try {
            withContext(Dispatchers.IO) {
               val characters = harryPoterAPI.getCharacter()
                Log.d(TAG, "getCharacter: $characters")
               characters.body()?: emptyList()
           }
       } catch (e:Exception) {
           Log.d(TAG, "getCharacter: ${e.message}")
           return emptyList()
       }
    }
    //retrieve a specificCharacterModel object by its id from an API using Retrofit and Coroutine's
    suspend fun getCharacterById(id: Int): SpecificCharacterModel {
        return withContext(Dispatchers.IO) {
            val characters = harryPoterAPI.getCharacterById(id)
            characters.body()!!
        }
    }
    //retrieve list of CharacterInHouse objects from an API using Retrofit library and corouti

    suspend fun getCharactersInHouse(houseName: String) {
        return withContext(Dispatchers.IO) {
            val characters = harryPoterAPI.getCharactersInHouse(houseName)
            characters.body()?: emptyList()
        }
    }

}