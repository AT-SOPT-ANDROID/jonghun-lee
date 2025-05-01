package org.sopt.at.login.ui.signin

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.sopt.at.login.util.LoginRepository

class SignInViewModel(private val repository: LoginRepository): ViewModel() {
    val _uiState = MutableStateFlow(SignInState())
    val uiState = _uiState.asStateFlow()

    fun updateUserId(id: String){
        _uiState.value = _uiState.value.copy(userId = id)
    }

    fun updateUserPassword(password: String){
        _uiState.value = _uiState.value.copy(userPassword = password)
    }

    fun togglePasswordVisiblity(){
        _uiState.value = _uiState.value.copy(
            isPasswordVisible = !_uiState.value.isPasswordVisible
        )
    }

    fun login(): Boolean{
        val id = _uiState.value.userId
        val password = _uiState.value.userPassword
        val isSuccess =repository.checkUser(id,password)
        if (isSuccess){
            repository.setLoginState(true)
        }
        _uiState.value = _uiState.value.copy(isLoginSuccess = isSuccess)
        return isSuccess
    }
    fun isAutoLoggedIn(): Boolean {
        return repository.getLoginState()
    }

}