package org.sopt.at.my

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import org.sopt.at.login.util.LoginRepository
import org.sopt.at.login.util.LoginViewModelFactory
import org.sopt.at.ui.theme.ATSOPTANDROIDTheme

class MyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val repository = LoginRepository(getSharedPreferences("prefs", MODE_PRIVATE))
        val viewModelFactory = LoginViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(MyViewModel::class.java)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ATSOPTANDROIDTheme {
                val navController = rememberNavController()
                MyScreen(viewModel,navController)
            }
        }
    }
}
