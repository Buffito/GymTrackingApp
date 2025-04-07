package com.thodoris.kotoufos.gymtrackingapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thodoris.kotoufos.gymtrackingapp.data.BodyFatCalculator.calculateBodyFat
import com.thodoris.kotoufos.gymtrackingapp.data.models.UserMeasurement
import com.thodoris.kotoufos.gymtrackingapp.data.models.UserProfile
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.math.round

@Composable
fun MeasurementItem(userMeasurement: UserMeasurement, userProfile: UserProfile) {
    val formatter = SimpleDateFormat("d/M/yyyy", Locale.getDefault())
    val formattedDate = formatter.format(Date(userMeasurement.timestamp))
    val fatPercentage = calculateBodyFat(userMeasurement, userProfile)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        Text("Weight (kg): ${userMeasurement.weight}", fontSize = 18.sp)
        Text("Neck (cm): ${userMeasurement.neck}", fontSize = 18.sp)

        if (userProfile.gender.lowercase() == "Female") {
            Text("Hip (cm): ${userMeasurement.hip}", fontSize = 18.sp)
        }

        Text("Waist (cm): ${userMeasurement.waist}", fontSize = 18.sp)

        Row {
            Text(
                text = "Date of measurement: ", fontSize = 18.sp
            )
            Text(
                text = formattedDate, fontSize = 18.sp
            )
        }


        Text("Body fat: ${userMeasurement.bodyFat} %", fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))

        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(), thickness = 1.dp, color = Color.Gray
        )
    }
}
