package org.sopt.at.data.datasource

import org.sopt.at.data.dto.base.BaseResponse
import org.sopt.at.data.dto.request.SignInRequest
import org.sopt.at.data.dto.request.SignUpRequest
import org.sopt.at.data.dto.response.NicknameResponse
import org.sopt.at.data.dto.response.SignInResponse
import org.sopt.at.data.dto.response.SignUpResponse

interface UserRemoteDataSource{
    suspend fun signUp(request: SignUpRequest): BaseResponse<SignUpResponse>
    suspend fun signIn(request: SignInRequest): BaseResponse<SignInResponse>
    suspend fun getNickName(userId: Long): BaseResponse<NicknameResponse>
}