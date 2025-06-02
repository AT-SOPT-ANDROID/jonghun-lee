package org.sopt.at.data.datasourceimpl

import org.sopt.at.data.service.UserService
import org.sopt.at.data.datasource.UserRemoteDataSource
import org.sopt.at.data.dto.base.BaseResponse
import org.sopt.at.data.dto.request.SignInRequest
import org.sopt.at.data.dto.request.SignUpRequest
import org.sopt.at.data.dto.response.NicknameResponse
import javax.inject.Inject

class UserRemoteDataSourceImpl @Inject constructor(private val userService: UserService) :
    UserRemoteDataSource {
    override suspend fun signUp(request: SignUpRequest) = userService.signUp(request)
    override suspend fun signIn(request: SignInRequest) = userService.signIn(request)
    override suspend fun getNickName(userId: Long): BaseResponse<NicknameResponse> = userService.getUserNickname(userId)
}