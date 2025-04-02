package com.thodoris.kotoufos.gymtrackingapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.thodoris.kotoufos.gymtrackingapp.data.daos.UserMeasurementDao
import com.thodoris.kotoufos.gymtrackingapp.data.daos.UserProfileDao
import com.thodoris.kotoufos.gymtrackingapp.data.daos.WorkoutLogDao
import com.thodoris.kotoufos.gymtrackingapp.data.models.UserMeasurement
import com.thodoris.kotoufos.gymtrackingapp.data.models.UserProfile
import com.thodoris.kotoufos.gymtrackingapp.data.models.WorkoutLog

@Database(entities = [WorkoutLog::class, UserMeasurement::class, UserProfile::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun workoutLogDao(): WorkoutLogDao
    abstract fun userMeasurementDao(): UserMeasurementDao
    abstract fun userProfileDao(): UserProfileDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, AppDatabase::class.java, "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}