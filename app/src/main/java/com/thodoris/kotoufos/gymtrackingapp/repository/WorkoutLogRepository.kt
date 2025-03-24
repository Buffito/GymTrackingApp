package com.thodoris.kotoufos.gymtrackingapp.repository

import com.thodoris.kotoufos.gymtrackingapp.data.daos.WorkoutLogDao
import javax.inject.Inject

class WorkoutLogRepository @Inject constructor(private val workoutLogDao: WorkoutLogDao) {
}