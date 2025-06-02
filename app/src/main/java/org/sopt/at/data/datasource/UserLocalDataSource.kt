package org.sopt.at.data.datasource

interface UserLocalDataSource {
    suspend fun saveUserId(userId: Long)
    suspend fun setLoginState(isLoggedIn: Boolean)
    suspend fun clearUserData()
    fun getUserId(): Long
    fun getLoginState(): Boolean
}
