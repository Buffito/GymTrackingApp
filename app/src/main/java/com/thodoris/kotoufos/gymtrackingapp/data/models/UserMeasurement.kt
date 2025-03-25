package com.thodoris.kotoufos.gymtrackingapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserMeasurements")
data class UserMeasurement(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    val weight: Float,
    val height: Float,
    val neck: Float,
    val hip: Float?, //only for women
    val waist: Float,
    val gender: String,
    val timestamp: Long = System.currentTimeMillis()
)