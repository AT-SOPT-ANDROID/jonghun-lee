package org.sopt.at.login.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.sopt.at.login.ui.signin.SignInViewModel
import org.sopt.at.login.ui.signup.SignUpViewModel
import org.sopt.at.my.MyViewModel

class LoginViewModelFactory(
    private val repository: LoginRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(SignInViewModel::class.java) ->
                SignInViewModel(repository) as T
            modelClass.isAssignableFrom(SignUpViewModel::class.java) ->
                SignUpViewModel(repository) as T
            modelClass.isAssignableFrom(MyViewModel::class.java) ->
                MyViewModel(repository) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
