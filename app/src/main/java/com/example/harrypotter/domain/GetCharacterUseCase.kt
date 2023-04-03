package com.example.harrypotter.domain

import com.example.harrypotter.domain.items.CharacterItem
import com.example.harrypotter.repo.HarryPotterRepository
import javax.inject.Inject

class GetCharacterUseCase @Inject constructor(private val harryPotterRepository: HarryPotterRepository) {

    //Defines use case for retrieving a list of CharacterItem objects from a datasource and shuffle their order
    suspend operator fun invoke(): List<CharacterItem> {
        return harryPotterRepository.getCharacter().shuffled()
    }
}