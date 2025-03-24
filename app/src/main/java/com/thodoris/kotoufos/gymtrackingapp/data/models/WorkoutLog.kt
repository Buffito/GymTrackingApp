package com.thodoris.kotoufos.gymtrackingapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WorkoutLog(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val exercise: String,
    val weight: Float,
    val reps: Int,
    val timestamp: Long = System.currentTimeMillis()
)
