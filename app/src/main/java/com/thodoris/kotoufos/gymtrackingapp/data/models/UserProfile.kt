package com.thodoris.kotoufos.gymtrackingapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserProfile")
data class UserProfile(
    @PrimaryKey val id: Int = 1, val height: Float, val gender: String
)
