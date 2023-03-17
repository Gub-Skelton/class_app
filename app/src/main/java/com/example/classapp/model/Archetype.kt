package com.example.classapp.model

data class Archetype(
    val archetypeName: String,
    val damageType: String,
    val image: String,
    val healthDie: Int,
    val position: String,
    val funLevel: Int,
    val complexity: String,
    val playable: Boolean,
    val id: Int,
    val description: String,
)