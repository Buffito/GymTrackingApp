package com.thodoris.kotoufos.gymtrackingapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.thodoris.kotoufos.gymtrackingapp.ui.viewmodel.UserMeasurementViewModel
import com.thodoris.kotoufos.gymtrackingapp.ui.viewmodel.WorkoutLogViewModel

@Composable
fun AppNavHost() {
    val userMeasurementViewModel : UserMeasurementViewModel = hiltViewModel()
    val workoutLogViewModel: WorkoutLogViewModel = hiltViewModel()

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main") {
        //TODO: make the screens
    }
}