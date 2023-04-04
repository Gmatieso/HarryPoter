package com.example.harrypotter.repo

import com.example.harrypotter.domain.items.*
import javax.inject.Inject

class HarryPotterRepository @Inject constructor(private val harryPotterService: HarryPotterService) {
    /*
   retrieves a list of CharacterModel objects from an API using Retrofit library
   maps them to a list of CharacterItem object using map fun
    */
    companion object {
        private const val TAG = "HarryPotterRepository"
    }
    suspend fun getCharacters(): List<CharacterItem> {
      return harryPotterService.getCharacters().map {
          it.toCharacterItem()
      }
    }

    suspend fun getCharacterById(id:Int): SpecificCharacterItem {
        return harryPotterService.getCharacterById(id).toSpecificCharacterItem()
    }

//    suspend fun getCharactersInHouseItem(house: String): List<GetCharactersInHouseItem> {
//        return harryPotterService.getCharactersInHouse(house).map {
//            it.toCharacterInHouseItem()
//
//    }
}