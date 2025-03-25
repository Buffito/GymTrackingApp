package com.thodoris.kotoufos.gymtrackingapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "WorkoutLogs")
data class WorkoutLog(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    val exercise: String,
    val weight: Float,
    val reps: Int,
    val timestamp: Long = System.currentTimeMillis()
)
