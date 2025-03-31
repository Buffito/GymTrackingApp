package com.thodoris.kotoufos.gymtrackingapp.data.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.thodoris.kotoufos.gymtrackingapp.data.models.UserProfile
import kotlinx.coroutines.flow.Flow

@Dao
interface UserProfileDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateProfile(profile: UserProfile)

    @Query("SELECT * FROM UserProfile") //there is only one
    fun getUserProfile(): Flow<UserProfile>
}