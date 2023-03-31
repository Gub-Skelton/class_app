package com.example.classapp.data.model

import com.example.classapp.model.DnDClass

sealed class DnDResponse{
    data class Success(val archetypes: List<DnDClass>) : DnDResponse()
    object Failure : DnDResponse()
}
