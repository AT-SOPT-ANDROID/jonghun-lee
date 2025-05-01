package org.sopt.at.presentation.splash

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.sopt.at.presentation.login.util.LoginRepository
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val repository: LoginRepository) : ViewModel()
{
    fun isAutoLoggedIn(): Boolean {
        return repository.getLoginState()
    }
}
