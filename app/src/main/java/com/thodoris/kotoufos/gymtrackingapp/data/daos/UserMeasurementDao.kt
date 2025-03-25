package com.thodoris.kotoufos.gymtrackingapp.data.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.thodoris.kotoufos.gymtrackingapp.data.models.UserMeasurement
import kotlinx.coroutines.flow.Flow

@Dao
interface UserMeasurementDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMeasurement(measurement: UserMeasurement)

    @Query("SELECT * FROM UserMeasurements ORDER BY timestamp DESC LIMIT 1")
    fun getLatestMeasurement(): UserMeasurement?

    @Query("SELECT * FROM UserMeasurements ORDER BY timestamp DESC")
    fun getAllMeasurements(): Flow<List<UserMeasurement>>
}