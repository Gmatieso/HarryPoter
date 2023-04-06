package com.example.harrypotter.core.domain.use_case

import com.example.harrypotter.core.data.HarryPotterApi

class GetCharacter(
    private val harryPotterApi: HarryPotterApi
) {
    suspend operator fun invoke(
        id: String
    ) = harryPotterApi.getCharacter(id)
}