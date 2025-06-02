package org.sopt.at.data.service

import org.sopt.at.data.dto.base.BaseResponse
import org.sopt.at.data.dto.request.SignInRequest
import org.sopt.at.data.dto.request.SignUpRequest
import org.sopt.at.data.dto.response.NicknameResponse
import org.sopt.at.data.dto.response.SignInResponse
import org.sopt.at.data.dto.response.SignUpResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface UserService {
    @POST("/api/v1/auth/signup")
    suspend fun signUp(
        @Body signUpRequestDto: SignUpRequest
    ) : BaseResponse<SignUpResponse>

    @POST("/api/v1/auth/signin")
    suspend fun signIn(
        @Body signInRequestDto: SignInRequest
    ) : BaseResponse<SignInResponse>
    @GET("/api/v1/users/me")
    suspend fun getUserNickname(
        @Header("userId") userId: Long
    ) : BaseResponse<NicknameResponse>


}
