package com.example.harrypotter.repo

import android.util.Log
import com.example.harrypotter.data.remote.HarryPoterAPI
import com.example.harrypotter.data.remote.HarryPotterService
import com.example.harrypotter.data.remote.models.CharacterModel
import com.example.harrypotter.domain.items.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HarryPotterRepository @Inject constructor(private val harryPoterAPI: HarryPoterAPI) {
    /*
   retrieves a list of CharacterModel objects from an API using Retrofit library
   maps them to a list of CharacterItem object using map fun
    */
    companion object {
         const val TAG = "HarryPotterRepository"
    }
    suspend fun getCharacter(): List<CharacterItem> {
        return try {
            withContext(Dispatchers.IO) {
                val characters = harryPoterAPI.getCharacter()
                Log.d(HarryPotterService.TAG, "getCharacter: $characters")
                characters.body()?.map { it.toCharacterItem() }
                    ?: emptyList()
            }
        } catch (e:Exception) {
            Log.d(HarryPotterService.TAG, "getCharacter: ${e.message}")
            return emptyList()
        }
    }

//    suspend fun getCharacterById(id:Int): SpecificCharacterItem {
//        return harryPotterService.getCharacterById(id).toSpecificCharacterItem()
//    }

//    suspend fun getCharactersInHouseItem(house: String): List<GetCharactersInHouseItem> {
//        return harryPotterService.getCharactersInHouse(house).map {
//            it.toCharacterInHouseItem()
//
//    }
}