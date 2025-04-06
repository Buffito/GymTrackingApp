package com.thodoris.kotoufos.gymtrackingapp.ui.screens.measurements

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.thodoris.kotoufos.gymtrackingapp.ui.components.EmptyListItem
import com.thodoris.kotoufos.gymtrackingapp.ui.components.MeasurementItem
import com.thodoris.kotoufos.gymtrackingapp.ui.viewmodel.UserMeasurementViewModel
import com.thodoris.kotoufos.gymtrackingapp.ui.viewmodel.UserProfileViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainMeasurementScreen(
    userMeasurementViewModel: UserMeasurementViewModel,
    userProfileViewModel: UserProfileViewModel,
    navController: NavHostController
) {
    val measurements by userMeasurementViewModel.allMeasurements.collectAsState(initial = emptyList())
    val lastMeasurement by userMeasurementViewModel.latestMeasurement()
        .collectAsState(initial = null)
    val userProfile by userProfileViewModel.profile.collectAsState(initial = null)

    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        TopAppBar(title = {
            Text("Measurements")
        })
    }, floatingActionButton = {
        FloatingActionButton(
            onClick = { navController.navigate("insertMeasurement") },
            containerColor = MaterialTheme.colorScheme.primary,
            shape = CircleShape
        ) {
            Icon(Icons.Default.Add, contentDescription = "Add Measurement")
        }
    }) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(8.dp)
        ) {
            if (measurements.isEmpty()) {
                item {
                    EmptyListItem(text = "No measurements found")
                }
            } else {
                items(measurements) { m ->
                    userProfile?.let { MeasurementItem(userMeasurement = m, userProfile = it) }
                }
            }
        }
    }
}