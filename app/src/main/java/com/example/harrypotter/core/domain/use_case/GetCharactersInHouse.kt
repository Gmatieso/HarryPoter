package com.example.harrypotter.core.domain.use_case

import com.example.harrypotter.core.data.HarryPotterApi

class GetCharactersInHouse(
    private val harryPotterApi: HarryPotterApi
) {
    suspend operator fun invoke(
        houseName: String
    ) = harryPotterApi.getCharactersInHouse(houseName)
}