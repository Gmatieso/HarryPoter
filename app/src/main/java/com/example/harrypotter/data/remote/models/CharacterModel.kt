package com.example.harrypotter.data.remote.models

data class CharacterModel(
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