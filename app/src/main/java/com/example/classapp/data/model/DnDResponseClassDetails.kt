package com.example.classapp.data.model

import com.example.classapp.model.DnDClassDetails
import retrofit2.Response

sealed class DnDResponseClassDetails {
    data class Success(val archetype: Response<DnDClassDetails>) : DnDResponseClassDetails()
    object Failure : DnDResponseClassDetails()
}