package com.example.harrypotter.core.domain.model

@kotlinx.serialization.Serializable
data class Wand(
    val core: String,
    val length: Double,
    val wood: String
)