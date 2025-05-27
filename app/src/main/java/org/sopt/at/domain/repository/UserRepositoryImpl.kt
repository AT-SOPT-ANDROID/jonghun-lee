package org.sopt.at.domain.repository

import android.content.SharedPreferences
import org.sopt.at.data.api.UserService
import org.sopt.at.data.dto.request.SignInRequestDto
import org.sopt.at.data.dto.request.SignUpRequestDto
import org.sopt.at.domain.model.NickNameRequestInfo
import org.sopt.at.domain.model.NicknameResponseInfo
import org.sopt.at.domain.model.SignInRequestInfo
import org.sopt.at.domain.model.SignInResponseInfo
import org.sopt.at.domain.model.SignUpRequestInfo
import org.sopt.at.domain.model.SignUpResponseInfo
import javax.inject.Inject
import androidx.core.content.edit


class UserRepositoryImpl @Inject constructor(
    private val userService: UserService,
    private val prefs: SharedPreferences
) : UserRepository {

    override suspend fun signUp(signUpRequestInfo: SignUpRequestInfo): Result<SignUpResponseInfo> =
        try {
            val requestDto = SignUpRequestDto(
                loginId = signUpRequestInfo.loginId,
                password = signUpRequestInfo.password,
                nickname = signUpRequestInfo.nickname
            )

            val response = userService.signUp(requestDto)

            if (response.success && response.data != null) {
                val userId = response.data.userId
                val nickname = response.data.nickname
                Result.success(SignUpResponseInfo(userId, nickname))
            } else {
                Result.failure(Exception(response.message))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }


    override suspend fun signIn(signInRequestInfo: SignInRequestInfo): Result<SignInResponseInfo> =
        try {
            val requestDto = SignInRequestDto(
                loginId = signInRequestInfo.loginId,
                password = signInRequestInfo.password
            )
            val response = userService.signIn(requestDto)

            if (response.success && response.data != null) {
                val userId = response.data.userId

                saveUserId(userId)
                setLoginState(true)

                Result.success(SignInResponseInfo(userId))
            } else {
                Result.failure(Exception(response.message))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }


    override suspend fun getNickname(nickNameRequestInfo: NickNameRequestInfo): Result<NicknameResponseInfo> =
        try {
            val response = userService.getUserNickname(nickNameRequestInfo.userId)
            if (response.success && response.data != null) {
                Result.success(NicknameResponseInfo(nickname = response.data.nickname))
            } else {
                Result.failure(Exception(response.message))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }

    override suspend fun saveUserId(userId: Long) {
        prefs.edit() { putLong(USER_ID, userId) }
    }


    override fun getUserId(): Long {
        return prefs.getLong(USER_ID, -1)
    }

    override suspend fun setLoginState(isLoggedIn: Boolean) {
        prefs.edit() { putBoolean(IS_LOGIN, isLoggedIn) }
    }

    override fun getLoginState(): Boolean {
        return prefs.getBoolean(IS_LOGIN, false)
    }

    override suspend fun clearUserData() {
        prefs.edit() { clear() }
    }


    companion object {
        private const val USER_ID = "user_id"
        private const val IS_LOGIN = "is_login"
    }

}