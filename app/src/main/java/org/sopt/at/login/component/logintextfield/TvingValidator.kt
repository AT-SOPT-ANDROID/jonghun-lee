package org.sopt.at.login.component.logintextfield

object TvingValidator {
    val idPattern = Regex("^[a-z0-9]{6,12}$")
    val passwordPattern = Regex("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#\$%^&*])[A-Za-z\\d~!@#\$%^&*]{8,15}\$")

    fun validateId(id: String): Boolean{
        return id.matches(idPattern)
    }

    fun validatePassword(password: String): Boolean{
        return password.matches(passwordPattern)
    }

}