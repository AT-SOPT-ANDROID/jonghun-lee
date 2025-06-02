package org.sopt.at.data.repositoryimpl


import org.sopt.at.data.dto.request.SignInRequest
import org.sopt.at.data.dto.request.SignUpRequest
import org.sopt.at.domain.model.NickNameRequestInfo
import org.sopt.at.domain.model.NicknameResponseInfo
import org.sopt.at.domain.model.SignInRequestInfo
import org.sopt.at.domain.model.SignInResponseInfo
import org.sopt.at.domain.model.SignUpRequestInfo
import org.sopt.at.domain.model.SignUpResponseInfo
import javax.inject.Inject
import org.sopt.at.data.datasource.UserLocalDataSource
import org.sopt.at.data.datasource.UserRemoteDataSource
import org.sopt.at.data.mapper.toNickNameResponseInfo
import org.sopt.at.data.mapper.toSignInResponseInfo
import org.sopt.at.data.mapper.toSignUpResponseInfo
import org.sopt.at.domain.repository.UserRepository


class UserRepositoryImpl @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource,
    private val userLocalDataSource: UserLocalDataSource
) : UserRepository {

    override suspend fun getNickname(nickNameRequestInfo: NickNameRequestInfo): Result<NicknameResponseInfo> =
        runCatching {
            val response = userRemoteDataSource.getNickName(nickNameRequestInfo.userId)
            response.data?.toNickNameResponseInfo() ?: throw Exception("닉네임이 없습니다.")
        }

    override suspend fun signUp(signUpRequestInfo: SignUpRequestInfo): Result<SignUpResponseInfo> =
        runCatching {
            val response = userRemoteDataSource.signUp(
                SignUpRequest(
                    loginId = signUpRequestInfo.loginId,
                    password = signUpRequestInfo.password,
                    nickname = signUpRequestInfo.nickname
                )
            )
            if (response.success && response.data != null) {
                response.data.toSignUpResponseInfo()
            } else {
                throw Exception(response.message)
            }
        }

    override suspend fun signIn(signInRequestInfo: SignInRequestInfo): Result<SignInResponseInfo> =
        runCatching {
            val response = userRemoteDataSource.signIn(
                SignInRequest(
                    loginId = signInRequestInfo.loginId,
                    password = signInRequestInfo.password
                )
            )
            if (response.success && response.data != null) {
                userLocalDataSource.saveUserId(response.data.userId)
                userLocalDataSource.setLoginState(true)
                response.data.toSignInResponseInfo()
            } else {
                throw Exception(response.message)
            }
        }

    override suspend fun saveUserId(userId: Long) = userLocalDataSource.saveUserId(userId)

    override suspend fun setLoginState(isLoggedIn: Boolean) =
        userLocalDataSource.setLoginState(isLoggedIn)

    override suspend fun clearUserData() = userLocalDataSource.clearUserData()

    override fun getLoginState(): Boolean = userLocalDataSource.getLoginState()

    override fun getUserId(): Long = userLocalDataSource.getUserId()
}
