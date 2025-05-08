package org.sopt.at.presentation.login.ui.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.at.data.repository.UserRepository
import javax.inject.Inject

sealed class SignInEvent {
    data class ShowSnackBar(val message: String) : SignInEvent()
}

@HiltViewModel
class SignInViewModel @Inject constructor(private val repository: UserRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(SignInState())
    val uiState = _uiState.asStateFlow()
    private val _sideEffect = MutableSharedFlow<SignInEvent>()
    val sideEffect: SharedFlow<SignInEvent> = _sideEffect.asSharedFlow()

    fun updateUserId(id: String) {
        val password = _uiState.value.userPassword
        _uiState.value = _uiState.value.copy(
            userId = id,
            isButtonEnabled = id.isNotBlank() && password.isNotBlank()
        )
    }

    fun updateUserPassword(password: String) {
        val userId = _uiState.value.userId
        _uiState.value = _uiState.value.copy(
            userPassword = password,
            isButtonEnabled = userId.isNotBlank() && password.isNotBlank()
        )
    }

    fun togglePasswordVisiblity() {
        _uiState.value = _uiState.value.copy(
            isPasswordVisible = !_uiState.value.isPasswordVisible
        )
    }

    fun login() {
        viewModelScope.launch {
            val id = _uiState.value.userId
            val password = _uiState.value.userPassword
            val isSuccess = repository.checkUser(id, password)

            if (isSuccess) {
                repository.setLoginState(true)
            } else {
                _sideEffect.emit(SignInEvent.ShowSnackBar("아이디 또는 비밀번호를 확인해주세요"))
            }

            _uiState.value = _uiState.value.copy(isLoginSuccess = isSuccess)
        }
    }


}