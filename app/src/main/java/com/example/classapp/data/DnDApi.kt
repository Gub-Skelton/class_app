package com.example.classapp.data

import com.example.classapp.data.model.DnDResponse
import com.example.classapp.model.DnDClassDetails
import com.example.classapp.model.DnDClassResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DnDApi {

    @GET(value = "/api/classes")
    suspend fun getClasses(): Response<DnDClassResponse>

    @GET(value = "/api/classes/")
    suspend fun getClass(@Query("index") index: String): Response<DnDClassDetails>



}