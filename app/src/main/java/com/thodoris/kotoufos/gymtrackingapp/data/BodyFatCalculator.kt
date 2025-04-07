package com.thodoris.kotoufos.gymtrackingapp.data

import com.thodoris.kotoufos.gymtrackingapp.data.models.UserMeasurement
import com.thodoris.kotoufos.gymtrackingapp.data.models.UserProfile
import kotlin.math.log10

// calculate body fat percentage using the US Navy method
object BodyFatCalculator {
    fun calculateBodyFat(measurement: UserMeasurement, userProfile: UserProfile): Float {
        val bodyFatPercentage = if (userProfile.gender == "Male") {
            (495 / (1.0324 - 0.19077 * log10((measurement.waist - measurement.neck).toDouble()) + 0.15456 * log10(
                userProfile.height.toDouble()
            ))) - 450
        } else {
            (495 / (1.29579 - 0.35004 * log10(
                (measurement.waist + (measurement.hip ?: 0f) - measurement.neck).toDouble()
            ) + 0.22100 * log10(userProfile.height.toDouble()))) - 450
        }

        return bodyFatPercentage.toFloat()
    }
}