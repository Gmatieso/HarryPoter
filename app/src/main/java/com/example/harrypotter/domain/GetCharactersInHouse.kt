package com.example.harrypotter.domain

import com.example.harrypotter.data.remote.HarryPoterAPI
import javax.inject.Inject

/*TODO implement charactersHouse*/
class GetCharactersInHouse @Inject constructor (private val harryPoterAPI: HarryPoterAPI)
{
    suspend operator fun invoke(
        houseName: String
    ) = harryPoterAPI.getCharactersInHouse(houseName)
}