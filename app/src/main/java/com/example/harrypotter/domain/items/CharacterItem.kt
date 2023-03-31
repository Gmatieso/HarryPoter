package com.example.harrypotter.domain.items

import com.example.harrypotter.data.remote.models.CharacterModel

data class CharacterItem(
    val id: Int,
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
/*
extension function that extends the CharacterModel class
to a new method called toCharacterItem()
By creating this extension function, any CharacterModel object can now call the toCharacterItem()
to convert itself to CharacterItem object without having to write a separate converter function
 */

fun CharacterModel.toCharacterItem() = CharacterItem(id,image, name, species, gender, ancestry, house, dateOfBirth, eyeColour, hairColour, wizard)