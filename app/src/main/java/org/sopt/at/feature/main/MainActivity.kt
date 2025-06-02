package org.sopt.at.feature.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.at.core.designsystem.theme.ATSOPTANDROIDTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ATSOPTANDROIDTheme {
                val navigator: MainNavigator = rememberMainNavigator()
                MainScreen(navigator = navigator)
                }
        }
    }
}