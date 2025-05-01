package org.sopt.at.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import org.sopt.at.component.AppNavHost
import org.sopt.at.ui.theme.ATSOPTANDROIDTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ATSOPTANDROIDTheme {
                val navController = rememberNavController()
                AppNavHost(navController = navController)
                }
        }
    }
}