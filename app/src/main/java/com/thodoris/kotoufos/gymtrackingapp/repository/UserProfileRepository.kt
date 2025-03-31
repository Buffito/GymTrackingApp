package com.thodoris.kotoufos.gymtrackingapp.repository

import com.thodoris.kotoufos.gymtrackingapp.data.daos.UserProfileDao
import com.thodoris.kotoufos.gymtrackingapp.data.models.UserProfile
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserProfileRepository @Inject constructor(private val userProfileDao: UserProfileDao) {
    val profile: Flow<UserProfile> = userProfileDao.getUserProfile()

    suspend fun insertUpdateProfile(userProfile: UserProfile) {
        userProfileDao.insertOrUpdateProfile(userProfile)
    }
}