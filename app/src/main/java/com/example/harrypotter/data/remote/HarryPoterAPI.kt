package com.example.harrypotter.data.remote

import com.example.harrypotter.data.remote.models.CharacterModel
import com.example.harrypotter.data.remote.models.Spell
import com.example.harrypotter.util.Constants.Companion.CHARACTERS_ENDPOINT
import com.example.harrypotter.util.Constants.Companion.HOUSES_ENDPOINT
import com.example.harrypotter.util.Constants.Companion.SPELLS_ENDPOINT
import com.example.harrypotter.util.Constants.Companion.STAFF_ENDPOINT
import com.example.harrypotter.util.Constants.Companion.STUDENTS_ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


/*
Type of Declaration that defines a set of
methods and properties that a class can implement
i.e a contract/set of requirements that a class must adhere to
 */

interface HarryPoterAPI {
    //retrofit2.http GET

    //  get all characters
    @GET(CHARACTERS_ENDPOINT)
    suspend fun getCharacters(): Response<List<CharacterModel>>  //Coroutine call to a suspend function for network Request

    //  get character with specific id
    @GET(CHARACTERS_ENDPOINT)
    suspend fun getCharacter(
        @Query("id") characterId: String
    ) : Response<CharacterModel>

    //  get characters in a house
    @GET(HOUSES_ENDPOINT)
    suspend fun getCharactersInHouse(
        @Path("houseName") houseName:String
    ): Response<List<GetCharactersInHouseModel>>

    //  characters who are Hogwarts staff
    @GET(STAFF_ENDPOINT)
    suspend fun getAllStaff(): Response<List<CharacterModel>>

    //  get all spells
    @GET(SPELLS_ENDPOINT)
    suspend fun getSpells(): Response<List<Spell>>

    //  characters who are Hogwarts students
    @GET(STUDENTS_ENDPOINT)
    suspend fun getStudents(): Response<List<CharacterModel>>


}