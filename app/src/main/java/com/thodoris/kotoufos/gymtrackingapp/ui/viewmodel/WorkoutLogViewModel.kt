package com.thodoris.kotoufos.gymtrackingapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thodoris.kotoufos.gymtrackingapp.data.models.WorkoutLog
import com.thodoris.kotoufos.gymtrackingapp.repository.WorkoutLogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WorkoutLogViewModel @Inject constructor(private val workoutLogRepository: WorkoutLogRepository) :
    ViewModel() {
    val allWorkouts: Flow<List<WorkoutLog>> = workoutLogRepository.allWorkouts

    fun insertWorkout(workoutLog: WorkoutLog) {
        viewModelScope.launch {
            workoutLogRepository.insertWorkoutLog(workoutLog)
        }
    }
}