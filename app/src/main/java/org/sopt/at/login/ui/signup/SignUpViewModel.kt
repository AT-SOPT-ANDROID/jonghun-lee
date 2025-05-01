package org.sopt.at.login.ui.signup

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.sopt.at.login.util.LoginRepository

class SignUpViewModel(private val repository: LoginRepository): ViewModel() {
    val _uiState = MutableStateFlow(SignUpState())
    val uiState = _uiState.asStateFlow()

    fun updateUserId(id:String){
        _uiState.value = _uiState.value.copy(userId = id)
    }

    fun updateUserPassword(password: String){
        _uiState.value = _uiState.value.copy(userPassword = password)
    }

    fun togglePasswordVisibility(){
        _uiState.value = _uiState.value.copy(
            isPasswordVisible = !_uiState.value.isPasswordVisible
        )
    }
    fun isPassword(){
        _uiState.value = _uiState.value.copy(isPassword = true)
    }

    fun signUp() {
        val id = _uiState.value.userId
        val password  = _uiState.value.userPassword
        repository.saveUser(id, password)
        _uiState.value = _uiState.value.copy(isSignUpComplete = true)
    }

}
