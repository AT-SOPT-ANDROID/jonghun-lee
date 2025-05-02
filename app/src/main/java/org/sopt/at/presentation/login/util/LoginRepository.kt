package org.sopt.at.presentation.login.util

import android.content.SharedPreferences
import javax.inject.Inject

class LoginRepository @Inject constructor(private val prefs: SharedPreferences) {

    fun saveUser(id: String, password: String) {
        prefs.edit().apply() {
            putString("USER_ID", id)
            putString("USER_PASSWORD", password)
            apply()
        }
    }

    fun getUserId(): String? {
        return prefs.getString("USER_ID", null)
    }

    fun checkUser(id: String, password: String): Boolean {
        val savedId = prefs.getString("USER_ID", null)
        val savedPassword = prefs.getString("USER_PASSWORD", null)
        return id == savedId && password == savedPassword
    }

    fun setLoginState(isLoggedIn: Boolean) {
        prefs.edit().apply() {
            putBoolean("IS_LOGGEDIN", isLoggedIn)
            apply()
        }
    }

    fun getLoginState(): Boolean {
        return prefs.getBoolean("IS_LOGGEDIN", false)
    }

    fun clearUserData() {
        prefs.edit().apply {
            remove("IS_LOGGEDIN")
            apply()
        }
    }
}