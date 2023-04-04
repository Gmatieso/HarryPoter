package com.example.harrypotter.domain.use_case

import com.example.harrypotter.data.remote.HarryPoterAPI


class GetCharactersInHouse(
    private val harryPotterApi: HarryPoterAPI
) {
    suspend operator fun invoke(
        houseName: String
    ) = harryPotterApi.getCharactersInHouse(houseName)
}