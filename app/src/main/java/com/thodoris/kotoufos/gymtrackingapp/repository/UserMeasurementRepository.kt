package com.thodoris.kotoufos.gymtrackingapp.repository

import com.thodoris.kotoufos.gymtrackingapp.data.daos.UserMeasurementDao
import com.thodoris.kotoufos.gymtrackingapp.data.models.UserMeasurement
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserMeasurementRepository @Inject constructor(private val userMeasurementDao: UserMeasurementDao) {
    val allMeasurements: Flow<List<UserMeasurement>> = userMeasurementDao.getAllMeasurements()

    fun getLatestMeasurement(): Flow<UserMeasurement> {
        return userMeasurementDao.getLatestMeasurement()
    }

    suspend fun insertMeasurement(userMeasurement: UserMeasurement) {
        userMeasurementDao.insertMeasurement(userMeasurement)
    }
}