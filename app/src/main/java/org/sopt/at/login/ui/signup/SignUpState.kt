package org.sopt.at.login.ui.signup

data class SignUpState(
    val userId: String = "",
    val userPassword: String = "",
    val isPasswordVisible : Boolean = false,
    val idError: String?= null,
    val passwordError: String?= null,
    val isPassword: Boolean = false,
    val isSignUpComplete: Boolean = false
)
