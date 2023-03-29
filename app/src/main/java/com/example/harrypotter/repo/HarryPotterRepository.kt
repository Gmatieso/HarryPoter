package com.example.harrypotter.repo

import com.example.harrypotter.data.remote.HarryPotterService
import com.example.harrypotter.domain.items.CharacterItem
import com.example.harrypotter.domain.items.SpecificCharacterItem
import com.example.harrypotter.domain.items.toCharacterItem
import com.example.harrypotter.domain.items.toSpecificCharacterItem
import javax.inject.Inject

class HarryPotterRepository @Inject constructor(private val harryPotterService: HarryPotterService) {
    /*
   retrieves a list of CharacterModel objects from an API using Retrofit library
   maps them to a list of CharacterItem object using map fun
    */
    suspend fun getCharacters(): List<CharacterItem> {
        return harryPotterService.getCharacter().map {
            it.toCharacterItem()
        }
    }

    suspend fun getCharacterById(house:String): SpecificCharacterItem {
        return harryPotterService.getCharacterById(house).toSpecificCharacterItem()
    }
}