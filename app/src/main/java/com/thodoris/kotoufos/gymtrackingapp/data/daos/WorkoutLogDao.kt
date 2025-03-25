package com.thodoris.kotoufos.gymtrackingapp.data.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.thodoris.kotoufos.gymtrackingapp.data.models.WorkoutLog
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkoutLogDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWorkout(workout: WorkoutLog)

    @Query("SELECT * FROM WorkoutLogs ORDER BY timestamp DESC")
    fun getAllWorkouts(): Flow<List<WorkoutLog>>
}