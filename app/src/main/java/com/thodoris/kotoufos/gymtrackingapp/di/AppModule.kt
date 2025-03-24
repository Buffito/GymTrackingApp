package com.thodoris.kotoufos.gymtrackingapp.di

import android.content.Context
import androidx.room.Room
import com.thodoris.kotoufos.gymtrackingapp.data.daos.UserMeasurementDao
import com.thodoris.kotoufos.gymtrackingapp.data.daos.WorkoutLogDao
import com.thodoris.kotoufos.gymtrackingapp.data.database.AppDatabase
import com.thodoris.kotoufos.gymtrackingapp.repository.UserMeasurementRepository
import com.thodoris.kotoufos.gymtrackingapp.repository.WorkoutLogRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideWorkoutLogRepository(workoutLogDao: WorkoutLogDao): WorkoutLogRepository {
        return WorkoutLogRepository(workoutLogDao)
    }

    @Provides
    fun provideUserMeasurementRepository(userMeasurementDao: UserMeasurementDao): UserMeasurementRepository {
        return UserMeasurementRepository(userMeasurementDao)
    }

    @Provides
    fun provideWorkoutDao(db: AppDatabase): WorkoutLogDao = db.workoutLogDao()

    @Provides
    fun provideUserMeasurementDao(db: AppDatabase): UserMeasurementDao = db.userMeasurementDao()

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "app_database").build()
}