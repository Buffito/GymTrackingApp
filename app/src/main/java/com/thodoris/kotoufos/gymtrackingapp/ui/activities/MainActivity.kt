package com.thodoris.kotoufos.gymtrackingapp.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.thodoris.kotoufos.gymtrackingapp.data.database.AppDatabase
import com.thodoris.kotoufos.gymtrackingapp.navigation.AppNavHost
import com.thodoris.kotoufos.gymtrackingapp.ui.theme.GymTrackingAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppDatabase.getDatabase(this)
        enableEdgeToEdge()
        setContent {
            GymTrackingAppTheme {
                AppNavHost()
            }
        }
    }
}
