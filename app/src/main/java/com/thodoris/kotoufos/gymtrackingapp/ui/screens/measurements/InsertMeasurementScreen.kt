package com.thodoris.kotoufos.gymtrackingapp.ui.screens.measurements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.thodoris.kotoufos.gymtrackingapp.data.models.UserMeasurement
import com.thodoris.kotoufos.gymtrackingapp.ui.components.InputField
import com.thodoris.kotoufos.gymtrackingapp.ui.viewmodel.UserMeasurementViewModel
import com.thodoris.kotoufos.gymtrackingapp.ui.viewmodel.UserProfileViewModel

@Composable
fun InsertMeasurementScreen(
    userMeasurementViewModel: UserMeasurementViewModel,
    userProfileViewModel: UserProfileViewModel,
    navController: NavHostController
) {
    var weight by remember { mutableStateOf("") }
    var waist by remember { mutableStateOf("") }
    var neck by remember { mutableStateOf("") }
    var hip by remember { mutableStateOf("") }

    val userProfile by userProfileViewModel.profile.collectAsState(initial = null)

    Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Add New Measurement", fontSize = 20.sp, fontWeight = FontWeight.Bold
            )

            InputField(value = weight, onValueChange = { weight = it }, label = "Weight (kg)")
            InputField(value = waist, onValueChange = { waist = it }, label = "Waist (cm)")
            InputField(value = neck, onValueChange = { neck = it }, label = "Neck (cm)")

            if (userProfile?.gender == "Female") {
                InputField(value = hip, onValueChange = { hip = it }, label = "Hip")
            }

            Button(
                onClick = {
                    if (weight.isNotEmpty() && waist.isNotEmpty() && neck.isNotEmpty()) {
                        val newMeasurement = neck.replace(",", ".").toFloatOrNull()?.let {
                            waist.replace(",", ".").toFloatOrNull()?.let { it1 ->
                                weight.replace(",", ".").toFloatOrNull()?.let { it2 ->
                                    UserMeasurement(
                                        weight = it2,
                                        waist = it1,
                                        neck = it,
                                        hip = hip.replace(",", ".").toFloatOrNull()
                                    )
                                }
                            }
                        }

                        if (newMeasurement != null) {
                            userMeasurementViewModel.insertMeasurement(newMeasurement)
                        }

                        navController.popBackStack()
                    }
                }, modifier = Modifier.fillMaxWidth()
            ) {
                Text("Save Measurement")
            }
        }
    }
}
