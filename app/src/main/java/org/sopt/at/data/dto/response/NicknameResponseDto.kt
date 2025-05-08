package org.sopt.at.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NicknameResponseDto(
    @SerialName("nickname")
    val nickname: String
)