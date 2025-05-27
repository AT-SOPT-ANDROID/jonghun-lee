package org.sopt.at.presentation.login.component.logintextfield

object TvingValidator {
    val idPattern = Regex("^[A-Za-z0-9]{8,20}$")
    val passwordPattern = Regex("^[A-Za-z0-9]{8,20}$")
    val nicknamePattern = Regex("^[가-힣a-zA-Z0-9]{1,20}$")


    fun validateId(id: String): Boolean{
        return id.matches(idPattern)
    }

    fun validatePassword(password: String): Boolean{
        return password.matches(passwordPattern)
    }

    fun validateNickname(nickname: String): Boolean{
        return  nickname.matches(nicknamePattern)
    }

}