package org.sopt.at.login.ui.signin

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import org.sopt.at.login.util.LoginRepository
import org.sopt.at.login.util.LoginViewModelFactory
import org.sopt.at.main.MainActivity


class SignInActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = LoginRepository(getSharedPreferences("prefs", MODE_PRIVATE))

        if (repository.getLoginState()) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
            return
        }

        val viewModelFactory = LoginViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(SignInViewModel::class.java)

        setContent {
            SignInScreen(viewModel, onNavigateToHome = {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            })
        }
    }
}
