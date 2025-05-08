package org.sopt.at.data.api

import org.sopt.at.data.dto.response.BaseResponseDto
import org.sopt.at.data.dto.response.SignUpResponseDto
import org.sopt.at.data.dto.request.SignInRequestDto
import org.sopt.at.data.dto.request.SignUpRequestDto
import org.sopt.at.data.dto.response.NicknameResponseDto
import org.sopt.at.data.dto.response.SignInResponseDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface UserService {
    @POST("/api/v1/auth/signup")
    suspend fun signUp(
        @Body signUpRequestDto: SignUpRequestDto
    ) : BaseResponseDto<SignUpResponseDto>

    @POST("/api/v1/auth/signin")
    suspend fun signIn(
        @Body signInRequestDto: SignInRequestDto
    ) : BaseResponseDto<SignInResponseDto>

    @GET("/api/v1/users/me")
    suspend fun getUserNickname(
        @Header("userId") userId: Long
    ) : BaseResponseDto<NicknameResponseDto>
}
