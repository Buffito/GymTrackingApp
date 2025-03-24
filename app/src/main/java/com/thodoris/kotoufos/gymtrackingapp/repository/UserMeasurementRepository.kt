package com.thodoris.kotoufos.gymtrackingapp.repository

import com.thodoris.kotoufos.gymtrackingapp.data.daos.UserMeasurementDao
import javax.inject.Inject

class UserMeasurementRepository @Inject constructor(private val userMeasurementDao: UserMeasurementDao){
}