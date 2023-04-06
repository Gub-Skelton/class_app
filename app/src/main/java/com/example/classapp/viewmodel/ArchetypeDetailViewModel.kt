package com.example.classapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.classapp.data.model.DnDResponseClassDetails
import com.example.classapp.data.repository.DnDRepository
import com.example.classapp.model.DnDClassDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ArchetypeDetailViewModel @Inject constructor(
    private val dnDRepository: DnDRepository
) : ViewModel() {

    private val _archetype = MutableStateFlow<DnDEventDetail>(DnDEventDetail.Loading)
    val archetype: StateFlow<DnDEventDetail> = _archetype

    fun fillDataDetail(index : String) {
        viewModelScope.launch {
            when (val result = dnDRepository.getClass(index)) {
                DnDResponseClassDetails.Failure -> _archetype.value = DnDEventDetail.Failure
                is DnDResponseClassDetails.Success -> _archetype.value =
                    DnDEventDetail.Success(result.archetype)
            }
        }
    }

    sealed class DnDEventDetail {
        data class Success(val archetype: Response<DnDClassDetails>) : DnDEventDetail()
        object Failure : DnDEventDetail()
        object Loading : DnDEventDetail()
    }

}