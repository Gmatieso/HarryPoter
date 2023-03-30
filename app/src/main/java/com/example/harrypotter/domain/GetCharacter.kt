package com.example.harrypotter.domain

import com.example.harrypotter.data.remote.HarryPotterApi


class GetCharacter(
    private val harryPotterApi: HarryPotterApi
) {
    suspend operator fun invoke(
        id: String
    ) = harryPotterApi.getCharacter(id)
}