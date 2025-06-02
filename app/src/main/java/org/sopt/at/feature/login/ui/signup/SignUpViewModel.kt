package org.sopt.at.feature.login.ui.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.at.domain.model.SignUpRequestInfo
import org.sopt.at.domain.repository.UserRepository
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val repository: UserRepository) : ViewModel() {
    val _uiState = MutableStateFlow(SignUpState())
    val uiState = _uiState.asStateFlow()

    fun updateUserId(id: String) {
        _uiState.value = _uiState.value.copy(userId = id)
    }

    fun updateUserPassword(password: String) {
        _uiState.value = _uiState.value.copy(userPassword = password)
    }

    fun updateNickname(nickname: String) {
        _uiState.value = _uiState.value.copy(nickname = nickname)
    }

    fun togglePasswordVisibility() {
        _uiState.value = _uiState.value.copy(
            isPasswordVisible = !_uiState.value.isPasswordVisible
        )
    }

    fun nextStep() {
        val next = when (_uiState.value.currentStep) {
            SignUpStep.ID -> SignUpStep.PASSWORD
            SignUpStep.PASSWORD -> SignUpStep.NICKNAME
            SignUpStep.NICKNAME -> SignUpStep.NICKNAME
        }
        _uiState.value = _uiState.value.copy(currentStep = next)
    }


    fun signUp(
        onError: (String) -> Unit
    ) {
        viewModelScope.launch {
            val id = _uiState.value.userId
            val password = _uiState.value.userPassword
            val nickname = _uiState.value.nickname

            val signUpReqeustInfo = repository.signUp(
                SignUpRequestInfo(
                    loginId = id,
                    password = password,
                    nickname = nickname
                )
            )
            signUpReqeustInfo
                .onSuccess {
                    _uiState.value = _uiState.value.copy(isSignUpComplete = true)
                }
                .onFailure {
                    onError(it.message ?: "회원가입 실패")
                }
        }
    }


}
