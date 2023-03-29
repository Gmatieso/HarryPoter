package com.example.harrypotter.domain.items

import com.example.harrypotter.data.remote.models.SpecificCharacterModel

data class SpecificCharacterItem(
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
extension function that extends the SpecificCharacterModel class
to a new method called toSpecificCharacterItem()
By creating this extension function, any SpecificCharacterModel object can now call the toSpecificCharacterItem()
to convert itself to SpecificCharacterItem object without having to write a separate converter function
 */
fun SpecificCharacterModel.toSpecificCharacterItem() = SpecificCharacterItem(image, name, species, gender, ancestry, house, dateOfBirth, eyeColour, hairColour, wizard)
