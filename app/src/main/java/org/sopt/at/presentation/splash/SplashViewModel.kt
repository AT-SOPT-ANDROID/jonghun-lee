package org.sopt.at.presentation.splash

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.sopt.at.domain.repository.UserRepository
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val repository: UserRepository) : ViewModel()
{
    fun isAutoLoggedIn(): Boolean {
        return repository.getLoginState()
    }
}
