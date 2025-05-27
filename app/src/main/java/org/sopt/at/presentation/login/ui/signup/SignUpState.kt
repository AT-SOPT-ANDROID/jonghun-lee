package org.sopt.at.presentation.login.ui.signup

data class SignUpState(
    val currentStep: SignUpStep = SignUpStep.ID,
    val userId: String = "",
    val userPassword: String = "",
    val nickname: String = "",
    val isPasswordVisible : Boolean = false,
    val idError: String?= null,
    val passwordError: String?= null,
    val isSignUpComplete: Boolean = false
)
