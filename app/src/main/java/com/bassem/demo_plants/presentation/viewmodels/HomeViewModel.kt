package com.bassem.demo_plants.presentation.viewmodels

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bassem.demo_plants.data.models.Result
import com.bassem.demo_plants.domain.usecases.FetchPlantsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val useCase: FetchPlantsUseCase) : ViewModel() {
    private var _plantsList = MutableStateFlow<Result<Any?>?>(null)
    val plantsList: Flow<Result<Any?>> get() = _plantsList.filterNotNull()

    init {
        fetchProperties()
    }

    @VisibleForTesting
    fun fetchProperties() = viewModelScope.launch {
        useCase().collect { result ->
            _plantsList.value = result
        }
    }

}