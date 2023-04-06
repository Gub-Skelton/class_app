package com.example.classapp.data.repository

import com.example.classapp.data.DnDApi
import com.example.classapp.data.model.DnDResponse
import com.example.classapp.data.model.DnDResponseClassDetails
import javax.inject.Inject

class DnDRepositoryImpl @Inject constructor(
    private val dnDAPI: DnDApi
) : DnDRepository{
    override suspend fun getClasses(): DnDResponse {
        val result = dnDAPI.getClasses()
        return if(result.isSuccessful){
            DnDResponse.Success(result.body()?.archetypes ?: emptyList())
        }else{
            DnDResponse.Failure
        }
    }

    override suspend fun getClass(index : String): DnDResponseClassDetails {
        val result = dnDAPI.getClass(index)
        return if(result.isSuccessful){
            DnDResponseClassDetails.Success(result)
        }else{
            DnDResponseClassDetails.Failure
        }
    }
}