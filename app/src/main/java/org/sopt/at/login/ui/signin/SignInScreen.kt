package org.sopt.at.login.ui.signin

import android.content.Intent
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
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import org.sopt.at.login.component.logintextfield.LoginTextField
import org.sopt.at.login.component.topbar.LoginBackTopBar
import org.sopt.at.my.MyActivity
import org.sopt.at.login.ui.signup.SignUpActivity
import org.sopt.at.ui.theme.TvingGray
import org.sopt.at.ui.theme.TvingRed

@Composable
fun SignInScreen(viewModel: SignInViewModel,
                 onNavigateToHome: () -> Unit){
    val context = LocalContext.current
    val uiState by viewModel.uiState.collectAsState()
    val snackBarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        if (viewModel.isAutoLoggedIn()) {
            onNavigateToHome()
        }
    }

    Box(modifier = Modifier.fillMaxSize().background(Color.Black)) {
        Column(
            modifier = Modifier.fillMaxSize().padding(horizontal = 15.dp)
        ) {
            LoginBackTopBar(modifier = Modifier.padding(top = 25.dp))
            Text(
                modifier = Modifier.padding(top = 40.dp),
                text = "TVING ID 로그인",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            LoginTextField(
                value = uiState.userId,
                onValueChange = viewModel::updateUserId,
                placeholder = "아이디",
                modifier = Modifier.padding(top = 25.dp)

            )
            LoginTextField(
                value = uiState.userPassword,
                onValueChange = viewModel::updateUserPassword,
                placeholder = "비밀번호",
                modifier = Modifier.padding(top = 15.dp),
                isPassword = true,
                passwordVisible = uiState.isPasswordVisible,
                onVisibilityToggle = viewModel::togglePasswordVisiblity
            )
            val isButtonEnabled = uiState.userId.isNotBlank() && uiState.userPassword.isNotBlank()
            Button(
                onClick = {
                    val success = viewModel.login()
                    if (success) {
                        val intent = Intent(context, MyActivity::class.java)
                        context.startActivity(intent)
                    } else {
                        coroutineScope.launch {
                            snackBarHostState.showSnackbar(
                                message = "아이디 또는 비밀번호를 확인해주세요.",
                                duration = SnackbarDuration.Short
                            )
                        }
                    }
                },
                enabled = isButtonEnabled,
                modifier = Modifier.fillMaxWidth().padding(top = 25.dp, bottom = 30.dp),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(vertical = 15.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isButtonEnabled) TvingRed else TvingGray,
                    contentColor = Color.White,
                    disabledContainerColor = TvingGray,
                    disabledContentColor = Color.LightGray
                )
            ) {
                Text(
                    text = "로그인하기",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.LightGray
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = "아이디 찾기",
                    color = Color.LightGray,
                    fontSize = 16.sp
                )
                VerticalDivider(
                    modifier = Modifier.height(22.dp),
                    color = Color.DarkGray,
                    thickness = 1.5.dp
                )
                Text(
                    text = "비밀번호 찾기",
                    color = Color.LightGray,
                    fontSize = 16.sp
                )
                VerticalDivider(
                    modifier = Modifier.height(22.dp),
                    color = Color.DarkGray,
                    thickness = 1.5.dp
                )
                Text(
                    text = "회원가입",
                    color = Color.LightGray,
                    fontSize = 16.sp,
                    modifier = Modifier.clickable {
                        val intent = Intent(context, SignUpActivity::class.java)
                        context.startActivity(intent)
                    }
                )
            }
            GooglePolicyText(modifier = Modifier.padding(top = 30.dp))
        }
        SnackbarHost(
            hostState = snackBarHostState,
            modifier = Modifier.align(Alignment.BottomCenter).imePadding().padding(15.dp)
        )
    }

}





//AnnotatedString으로 특정 텍스트에 underline 과 스타일 주기
@Composable
fun GooglePolicyText(
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