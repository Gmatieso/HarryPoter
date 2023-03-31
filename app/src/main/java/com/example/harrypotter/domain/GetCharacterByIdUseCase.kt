package com.example.harrypotter.domain

import com.example.harrypotter.domain.items.CharacterItem
import com.example.harrypotter.domain.items.SpecificCharacterItem
import com.example.harrypotter.repo.HarryPotterRepository
import javax.inject.Inject

class GetCharacterByIdUseCase @Inject constructor(private val harryPotterRepository: HarryPotterRepository) {
    suspend operator fun invoke(id: Int): SpecificCharacterItem {
        return harryPotterRepository.getCharacterById(id)
    }
}