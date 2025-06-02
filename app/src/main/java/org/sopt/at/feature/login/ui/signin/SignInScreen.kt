package org.sopt.at.feature.login.ui.signin

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import org.sopt.at.feature.login.component.logintextfield.LoginTextField
import org.sopt.at.core.designsystem.theme.TvingGray
import org.sopt.at.core.designsystem.theme.TvingRed

@Composable
fun SignInRoute(
    onSignUpClick: () -> Unit,
    onSignInClick: () -> Unit,
    viewModel: SignInViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val snackBarHostState = remember { SnackbarHostState() }

    LaunchedEffect(uiState.isLoginSuccess) {
        if (uiState.isLoginSuccess) {
            onSignInClick()
        }
    }
    LaunchedEffect(Unit) {
        viewModel.sideEffect.collect { event ->
            when (event) {
                is SignInEvent.ShowSnackBar -> {
                    snackBarHostState.showSnackbar(event.message)
                }
            }
        }
    }

    SignInScreen(
        userId = uiState.userId,
        userPassword = uiState.userPassword,
        isPasswordVisible = uiState.isPasswordVisible,
        isButtonEnabled = uiState.isButtonEnabled,
        onIdChange = viewModel::updateUserId,
        onPasswordChange = viewModel::updateUserPassword,
        onVisibilityToggle = viewModel::togglePasswordVisiblity,
        onLoginClick = viewModel::login,
        onSignUpClick = onSignUpClick,
        snackBarHostState = snackBarHostState
    )
}


@Composable
fun SignInScreen(
    userId: String,
    userPassword: String,
    isPasswordVisible: Boolean,
    isButtonEnabled: Boolean,
    onIdChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onVisibilityToggle: () -> Unit,
    onLoginClick: () -> Unit,
    onSignUpClick: () -> Unit,
    snackBarHostState: SnackbarHostState
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 15.dp)
        ) {
            Text(
                text = "TVING ID 로그인",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(top = 40.dp)
            )
            LoginTextField(
                value = userId,
                onValueChange = onIdChange,
                placeholder = "아이디",
                modifier = Modifier.padding(top = 25.dp)
            )
            LoginTextField(
                value = userPassword,
                onValueChange = onPasswordChange,
                placeholder = "비밀번호",
                isPassword = true,
                passwordVisible = isPasswordVisible,
                onVisibilityToggle = onVisibilityToggle,
                modifier = Modifier.padding(top = 15.dp)
            )

            Button(
                onClick = onLoginClick,
                enabled = isButtonEnabled,
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(vertical = 15.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isButtonEnabled) TvingRed else TvingGray,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp, bottom = 30.dp)
            ) {
                Text(
                    text = "로그인하기",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.LightGray
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text("아이디 찾기", color = Color.LightGray, fontSize = 16.sp)
                VerticalDivider(Modifier.height(22.dp), color = Color.DarkGray, thickness = 1.5.dp)
                Text("비밀번호 찾기", color = Color.LightGray, fontSize = 16.sp)
                VerticalDivider(Modifier.height(22.dp), color = Color.DarkGray, thickness = 1.5.dp)
                Text(
                    text = "회원가입",
                    color = Color.LightGray,
                    fontSize = 16.sp,
                    modifier = Modifier.clickable { onSignUpClick() }
                )
            }

            GooglePolicyText(modifier = Modifier.padding(top = 30.dp))
        }

        SnackbarHost(
            hostState = snackBarHostState,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .imePadding()
                .padding(15.dp)
        )
    }
}



//AnnotatedString으로 특정 텍스트에 underline 과 스타일 주기
@Composable
private fun GooglePolicyText(
    modifier: Modifier = Modifier
) {
    val policyText = buildAnnotatedString {
        append("이 사이트는 Google reCAPTCHA로 보호되며,\n")
        withStyle(
            style = SpanStyle(
                textDecoration = TextDecoration.Underline,
            )
        ) {
            append("Google 개인정보 처리방침")
        }
        append("과 ")
        withStyle(
            style = SpanStyle(
                textDecoration = TextDecoration.Underline,
            )
        ) {
            append("서비스 약관")
        }
        append("이 적용됩니다.")
    }
    Text(
        text = policyText,
        color = TvingGray,
        fontSize = 13.sp,
        textAlign = TextAlign.Center,
        modifier = modifier.fillMaxWidth()
    )
}