package com.thodoris.kotoufos.gymtrackingapp.repository

import com.thodoris.kotoufos.gymtrackingapp.data.daos.WorkoutLogDao
import com.thodoris.kotoufos.gymtrackingapp.data.models.WorkoutLog
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WorkoutLogRepository @Inject constructor(private val workoutLogDao: WorkoutLogDao) {
    val allWorkouts: Flow<List<WorkoutLog>> = workoutLogDao.getAllWorkouts()

    suspend fun insertWorkoutLog(workoutLog: WorkoutLog) {
        workoutLogDao.insertWorkout(workoutLog)
    }

}