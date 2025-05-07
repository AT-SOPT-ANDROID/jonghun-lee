package org.sopt.at.data.repository

interface UserRepository{

    suspend fun saveUser(id: String, password: String)
    fun getUserId(): String?
    suspend fun checkUser(id: String, password: String): Boolean
    suspend fun setLoginState(isLoggedIn: Boolean)
    fun getLoginState(): Boolean
    suspend fun clearUserData()

}