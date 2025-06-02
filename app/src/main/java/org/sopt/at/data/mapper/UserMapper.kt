package org.sopt.at.data.mapper

import org.sopt.at.data.dto.response.NicknameResponse
import org.sopt.at.data.dto.response.SignInResponse
import org.sopt.at.data.dto.response.SignUpResponse
import org.sopt.at.domain.model.NicknameResponseInfo
import org.sopt.at.domain.model.SignInResponseInfo
import org.sopt.at.domain.model.SignUpResponseInfo

fun NicknameResponse.toNickNameResponseInfo(): NicknameResponseInfo =
    NicknameResponseInfo(nickname = this.nickname)

fun SignUpResponse.toSignUpResponseInfo(): SignUpResponseInfo =
    SignUpResponseInfo(userId = this.userId, nickname = this.nickname)

fun SignInResponse.toSignInResponseInfo(): SignInResponseInfo =
    SignInResponseInfo(userId = this.userId)
