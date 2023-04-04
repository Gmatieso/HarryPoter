package com.example.harrypotter.domain.use_case

import com.example.harrypotter.data.remote.HarryPoterAPI


class GetStudents(
    private val harryPotterApi: HarryPoterAPI
) {
    suspend operator fun invoke() = harryPotterApi.getStudents()
}