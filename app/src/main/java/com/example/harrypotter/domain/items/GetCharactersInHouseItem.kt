package com.example.harrypotter.domain.items

import com.example.harrypotter.data.remote.models.GetCharactersInHouseModel

/*TODO implement charactersHouse*/
data class GetCharactersInHouseItem(
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

fun GetCharactersInHouseModel.toCharacterInHouseItem() = GetCharactersInHouseItem(image, name, species, gender, ancestry, house, dateOfBirth, eyeColour, hairColour, wizard)
