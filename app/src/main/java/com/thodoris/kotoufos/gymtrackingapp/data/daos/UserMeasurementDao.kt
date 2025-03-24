package com.thodoris.kotoufos.gymtrackingapp.data.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.thodoris.kotoufos.gymtrackingapp.data.models.UserMeasurement

@Dao
interface UserMeasurementDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMeasurement(measurement: UserMeasurement)

    @Query("SELECT * FROM UserMeasurement ORDER BY timestamp DESC LIMIT 1")
    suspend fun getLatestMeasurement(): UserMeasurement?
}