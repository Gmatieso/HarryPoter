package com.example.harrypotter.domain

import com.example.harrypotter.data.remote.HarryPotterApi


class GetCharactersInHouse(
    private val harryPotterApi: HarryPotterApi
) {
    suspend operator fun invoke(
        houseName: String
    ) = harryPotterApi.getCharactersInHouse(houseName)
}