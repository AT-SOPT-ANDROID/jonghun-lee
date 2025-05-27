package org.sopt.at.domain.repository

import org.sopt.at.domain.model.NickNameRequestInfo
import org.sopt.at.domain.model.NicknameResponseInfo
import org.sopt.at.domain.model.SignInRequestInfo
import org.sopt.at.domain.model.SignInResponseInfo
import org.sopt.at.domain.model.SignUpRequestInfo
import org.sopt.at.domain.model.SignUpResponseInfo

interface UserRepository{
    suspend fun signUp(signUpRequestInfo: SignUpRequestInfo): Result<SignUpResponseInfo>
    suspend fun signIn(signInRequestInfo: SignInRequestInfo): Result<SignInResponseInfo>
    suspend fun getNickname(nickNameRequestInfo: NickNameRequestInfo): Result<NicknameResponseInfo>

    suspend fun saveUserId(userId: Long)
    fun getUserId(): Long
    suspend fun setLoginState(isLoggedIn: Boolean)
    fun getLoginState(): Boolean
    suspend fun clearUserData()

}