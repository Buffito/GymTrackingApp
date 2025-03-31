package com.thodoris.kotoufos.gymtrackingapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thodoris.kotoufos.gymtrackingapp.data.models.UserProfile
import com.thodoris.kotoufos.gymtrackingapp.repository.UserProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserProfileViewModel @Inject constructor(private val userProfileRepository: UserProfileRepository) :
    ViewModel() {
    val profile: Flow<UserProfile> = userProfileRepository.profile

    fun insertUpdateProfile(userProfile: UserProfile) {
        viewModelScope.launch {
            userProfileRepository.insertUpdateProfile(userProfile)
        }
    }
}