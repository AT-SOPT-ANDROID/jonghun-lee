package org.sopt.at.data.repository

import android.content.SharedPreferences
import javax.inject.Inject


class UserRepositoryImpl @Inject constructor(private val prefs: SharedPreferences) :
    UserRepository {
    override suspend fun saveUser(id: String, password: String) {
        prefs.edit().apply() {
            putString(USER_ID, id)
            putString(USER_PW, password)
            apply()
        }
    }

    override fun getUserId(): String? {
        return prefs.getString(USER_ID, null)
    }

    override suspend fun checkUser(id: String, password: String): Boolean {
        val savedId = prefs.getString(USER_ID, null)
        val savedPassword = prefs.getString(USER_PW, null)
        return id == savedId && password == savedPassword
    }

    override suspend fun setLoginState(isLoggedIn: Boolean) {
        prefs.edit().apply() {
            putBoolean(IS_LOGIN, isLoggedIn)
            apply()
        }
    }

    override fun getLoginState(): Boolean {
        return prefs.getBoolean(IS_LOGIN, false)
    }

    override suspend fun clearUserData() {
        prefs.edit().apply {
            remove(IS_LOGIN)
            apply()
        }
    }

    companion object {
        private const val USER_ID = "user_id"
        private const val USER_PW = "user_pw"
        private const val IS_LOGIN = "is_login"
    }

}