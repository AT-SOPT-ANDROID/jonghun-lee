package org.sopt.at.data.datasourceimpl

import android.content.SharedPreferences
import androidx.core.content.edit
import org.sopt.at.data.datasource.UserLocalDataSource
import javax.inject.Inject

class UserLocalDataSourceImpl @Inject constructor(
    private val prefs: SharedPreferences
) : UserLocalDataSource {

    override suspend fun saveUserId(userId: Long) {
        prefs.edit { putLong(USER_ID, userId) }
    }

    override fun getUserId(): Long = prefs.getLong(USER_ID, -1)

    override suspend fun setLoginState(isLoggedIn: Boolean) {
        prefs.edit { putBoolean(IS_LOGIN, isLoggedIn) }
    }

    override fun getLoginState(): Boolean = prefs.getBoolean(IS_LOGIN, false)

    override suspend fun clearUserData() {
        prefs.edit { clear() }
    }

    companion object {
        private const val USER_ID = "user_id"
        private const val IS_LOGIN = "is_login"
    }
}
