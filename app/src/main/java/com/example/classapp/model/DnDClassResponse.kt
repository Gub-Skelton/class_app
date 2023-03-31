package com.example.classapp.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = false)
data class DnDClassResponse(
    @Json(name = "count")
    val count: Int,
    @field:Json(name = "results")
    val archetypes: List<DnDClass>
)