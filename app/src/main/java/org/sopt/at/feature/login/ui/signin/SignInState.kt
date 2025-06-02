package org.sopt.at.feature.login.ui.signin

data class SignInState(
    val userId: String = "",
    val userPassword: String = "",
    val isPasswordVisible: Boolean = false,
    val isLoginSuccess: Boolean = false,
    val isButtonEnabled: Boolean = false
)
