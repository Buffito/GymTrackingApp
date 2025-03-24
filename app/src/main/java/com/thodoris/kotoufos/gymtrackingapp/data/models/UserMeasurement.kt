package com.thodoris.kotoufos.gymtrackingapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserMeasurement(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val weight: Float,
    val height: Float,
    val neck: Float,
    val hip: Float?, //only for women
    val waist: Float,
    val gender: String,
    val timestamp: Long = System.currentTimeMillis()
)