package org.sopt.at.presentation.login.ui.signup

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import org.sopt.at.presentation.login.component.topbar.LoginBackTopBar
import org.sopt.at.presentation.login.component.logintextfield.LoginTextField
import org.sopt.at.presentation.login.component.logintextfield.TvingValidator
import org.sopt.at.ui.theme.TvingGray
import org.sopt.at.ui.theme.TvingRed

@Composable
fun SignUpRoute(
    modifier: Modifier,
    navigateToSignIn: () -> Unit,
    onBackClick: () -> Unit,
    viewModel: SignUpViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(uiState.isSignUpComplete) {
        if (uiState.isSignUpComplete) {
            navigateToSignIn()
        }
    }

    SignUpScreen(
        modifier = modifier,
        currentStep = uiState.currentStep,
        userId = uiState.userId,
        userPassword = uiState.userPassword,
        nickname = uiState.nickname,
        isPasswordVisible = uiState.isPasswordVisible,
        onBackClick = onBackClick,
        onUserIdChange = viewModel::updateUserId,
        onUserPasswordChange = viewModel::updateUserPassword,
        onNicknameChange = viewModel::updateNickname,
        onTogglePasswordVisibility = viewModel::togglePasswordVisibility,
        onNextClick = {
            when (uiState.currentStep) {
                SignUpStep.ID -> {
                    if (!TvingValidator.validateId(uiState.userId)) {
                        Toast.makeText(context, "아이디 형식이 이상해요.", Toast.LENGTH_SHORT).show()
                    } else {
                        viewModel.nextStep()
                    }
                }

                SignUpStep.PASSWORD -> {
                    if (!TvingValidator.validatePassword(uiState.userPassword)) {
                        Toast.makeText(context, "비밀번호 형식이 이상해요.", Toast.LENGTH_SHORT).show()
                    } else {
                        viewModel.nextStep()
                    }
                }
                // TODO: 회원가입 호출 로직 수정
                SignUpStep.NICKNAME -> {
                    if (!TvingValidator.validateNickname(uiState.nickname)) {
                        Toast.makeText(context, "닉네임 형식이 이상해요.", Toast.LENGTH_SHORT).show()
                    } else {
                        viewModel.signUp { message ->
                            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                        }
                    }
                }

            }
        }
    )
}

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    currentStep: SignUpStep,
    userId: String,
    userPassword: String,
    nickname: String,
    isPasswordVisible: Boolean,
    onBackClick: () -> Unit,
    onUserIdChange: (String) -> Unit,
    onUserPasswordChange: (String) -> Unit,
    onNicknameChange: (String) -> Unit,
    onTogglePasswordVisibility: () -> Unit,
    onNextClick: () -> Unit
) {
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(horizontal = 15.dp),
        containerColor = Color.Black,
        bottomBar = {
            val isButtonEnabled = when (currentStep) {
                SignUpStep.ID -> userId.isNotBlank()
                SignUpStep.PASSWORD -> userPassword.isNotBlank()
                SignUpStep.NICKNAME -> nickname.isNotBlank()
            }

            Button(
                onClick = onNextClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 40.dp)
                    .border(
                        width = 0.5.dp, color = Color.LightGray, shape = RoundedCornerShape(4.dp)
                    ),
                enabled = isButtonEnabled,
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isButtonEnabled) TvingRed else Color.Black,
                    contentColor = Color.White,
                    disabledContainerColor = Color.Black,
                    disabledContentColor = Color.LightGray
                ),
                contentPadding = PaddingValues(vertical = 15.dp)
            ) {
                Text(
                    "다음", fontSize = 17.sp, fontWeight = FontWeight.Bold, color = Color.LightGray
                )
            }
        }) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            LoginBackTopBar(modifier = Modifier.padding(top = 25.dp), onClick = onBackClick)

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp),
                text = when (currentStep) {
                    SignUpStep.ID -> "아이디를 입력해주세요."
                    SignUpStep.PASSWORD -> "비밀번호를 입력해주세요."
                    SignUpStep.NICKNAME -> "닉네임을 입력해주세요."
                },
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center
            )

            when (currentStep) {
                SignUpStep.ID -> {
                    LoginTextField(
                        value = userId,
                        onValueChange = onUserIdChange,
                        placeholder = "아이디",
                        modifier = Modifier.padding(top = 20.dp)
                    )
                    Text(
                        text = "대문자 소문자 숫자 조합 8~20자리",
                        color = TvingGray,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 10.dp)
                    )
                }

                SignUpStep.PASSWORD -> {
                    LoginTextField(
                        value = userPassword,
                        onValueChange = onUserPasswordChange,
                        placeholder = "비밀번호",
                        modifier = Modifier.padding(top = 20.dp),
                        isPassword = true,
                        passwordVisible = isPasswordVisible,
                        onVisibilityToggle = onTogglePasswordVisibility
                    )
                    Text(
                        text = "대문자 소문자 숫자 조합 8~20자리",
                        color = TvingGray,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 10.dp)
                    )
                }

                SignUpStep.NICKNAME -> {
                    LoginTextField(
                        value = nickname,
                        onValueChange = onNicknameChange,
                        placeholder = "닉네임",
                        modifier = Modifier.padding(top = 20.dp)
                    )
                    Text(
                        text = "한글 영문 숫자 조합 1~20자리",
                        color = TvingGray,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 10.dp)
                    )
                }
            }
        }
    }
}
