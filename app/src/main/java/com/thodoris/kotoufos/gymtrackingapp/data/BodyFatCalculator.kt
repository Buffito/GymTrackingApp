package com.thodoris.kotoufos.gymtrackingapp.data

import com.thodoris.kotoufos.gymtrackingapp.data.models.UserMeasurement
import com.thodoris.kotoufos.gymtrackingapp.data.models.UserProfile
import kotlin.math.log10

// calculate body fat percentage using the US Nave method
object BodyFatCalculator {
    fun calculateBodyFat(measurement: UserMeasurement, userProfile: UserProfile): Float {
        return if (userProfile.gender == "male") {
            (86.01 * log10((measurement.waist - measurement.neck).toDouble()) - 70.041 * log10(
                userProfile.height.toDouble()
            ) + 36.76).toFloat()
        } else {
            (163.205 * log10(
                (measurement.waist + (measurement.hip ?: 0f) - measurement.neck).toDouble()
            ) - 97.684 * log10(userProfile.height.toDouble()) - 78.387).toFloat()
        }
    }
}