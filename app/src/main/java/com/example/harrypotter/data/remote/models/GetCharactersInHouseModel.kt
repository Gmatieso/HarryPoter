package com.example.harrypotter.data.remote.models

/*TODO implement charactersHouse*/
data class GetCharactersInHouseModel(
    val image: String,
    val name: String,
    val species: String,
    val gender: String,
    val ancestry: String,
    val house: String,
    val dateOfBirth: String,
    val eyeColour: String,
    val hairColour: String,
    val wizard: Boolean,
)
