package com.example.classapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.classapp.data.model.DnDResponse
//import com.example.classapp.data.model.DnDResponseClassDetails
import com.example.classapp.data.repository.DnDRepository
import com.example.classapp.model.DnDClass
import com.example.classapp.model.DnDClassDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArchetypeViewModel @Inject constructor(
    private val dnDRepository: DnDRepository
) : ViewModel() {

    private val _archetypes = MutableStateFlow<DnDEvent>(DnDEvent.Loading)
    val archetypes: StateFlow<DnDEvent> = _archetypes

    private val _archetype = MutableStateFlow<DnDEvent2>(DnDEvent2.Loading)
    val archetype: StateFlow<DnDEvent2> = _archetype

    fun fillData() {
        viewModelScope.launch {
            when (val result = dnDRepository.getClasses()) {
                DnDResponse.Failure -> _archetypes.value = DnDEvent.Failure
                is DnDResponse.Success -> _archetypes.value =
                    DnDEvent.Success(result.archetypes)
            }
        }
    }

//    fun fillData2() {
//        viewModelScope.launch {
//            when (val result = dnDRepository.getClass()) {
//                DnDResponseClassDetails.Failure -> _archetype.value = DnDEvent2.Failure
//                is DnDResponseClassDetails.Success -> _archetype.value =
//                    DnDEvent2.Success(result.archetype)
//            }
//        }
//    }

    sealed class DnDEvent {
        data class Success(val archetypes: List<DnDClass>) : DnDEvent()
        object Failure : DnDEvent()
        object Loading : DnDEvent()
    }
    sealed class DnDEvent2 {
        data class Success(val archetype : DnDClassDetails) : DnDEvent2()
        object Failure : DnDEvent2()
        object Loading : DnDEvent2()
    }
}