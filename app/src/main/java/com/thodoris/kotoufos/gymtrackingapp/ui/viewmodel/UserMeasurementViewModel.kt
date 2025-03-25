package com.thodoris.kotoufos.gymtrackingapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thodoris.kotoufos.gymtrackingapp.data.models.UserMeasurement
import com.thodoris.kotoufos.gymtrackingapp.repository.UserMeasurementRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserMeasurementViewModel @Inject constructor(private val userMeasurementRepository: UserMeasurementRepository) :
    ViewModel() {
    val allMeasurements: Flow<List<UserMeasurement>> = userMeasurementRepository.allMeasurements
    val latestMeasurement: UserMeasurement? = userMeasurementRepository.latestMeasurement

    fun insertMeasurement(userMeasurement: UserMeasurement) {
        viewModelScope.launch {
            userMeasurementRepository.insertMeasurement(userMeasurement)
        }
    }
}