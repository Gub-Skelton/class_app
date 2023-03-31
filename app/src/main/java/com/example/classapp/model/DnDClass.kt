package com.example.classapp.model


import com.squareup.moshi.Json

data class DnDClass(
    @Json(name = "index")
    val index: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "url")
    val url: String
)