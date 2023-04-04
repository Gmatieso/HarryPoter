package com.example.harrypotter.domain.use_case

import com.example.harrypotter.data.remote.HarryPoterAPI


class GetCharacter(
    private val harryPotterApi: HarryPoterAPI
) {
    suspend operator fun invoke(
        id: String
    ) = harryPotterApi.getCharacter(id)
}