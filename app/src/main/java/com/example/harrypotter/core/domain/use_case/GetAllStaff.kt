package com.example.harrypotter.core.domain.use_case

import com.example.harrypotter.core.data.HarryPotterApi

class GetAllStaff(
    private val harryPotterApi: HarryPotterApi
) {
    suspend operator fun invoke() = harryPotterApi.getAllStaff()
}