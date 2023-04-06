package com.example.classapp.data.repository

import com.example.classapp.data.model.DnDResponse
import com.example.classapp.data.model.DnDResponseClassDetails

interface DnDRepository {
    suspend fun getClasses(): DnDResponse
    suspend fun getClass(index : String): DnDResponseClassDetails
}