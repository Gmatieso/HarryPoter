package com.example.harrypotter.domain

import com.example.harrypotter.data.remote.HarryPotterApi


class GetSpells(
    private val harryPotterApi: HarryPotterApi
) {
    suspend operator fun invoke() = harryPotterApi.getSpells()
}