package org.sopt.at.login.ui.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import org.sopt.at.ui.theme.ATSOPTANDROIDTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import org.sopt.at.login.ui.signin.SignInViewModel
import org.sopt.at.login.util.LoginRepository
import org.sopt.at.login.util.LoginViewModelFactory


class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository = LoginRepository(getSharedPreferences("prefs", MODE_PRIVATE))
        val viewModelFactory = LoginViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(SignUpViewModel::class.java)
        setContent {
            ATSOPTANDROIDTheme {
                SignUpScreen(viewModel)
                }
            }
        }
    }
