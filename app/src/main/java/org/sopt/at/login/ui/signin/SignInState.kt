package org.sopt.at.login.ui.signin

data class SignInState(
    val userId: String = "",
    val userPassword: String = "",
    val isPasswordVisible: Boolean = false,
    val isLoginSuccess: Boolean = false
)
