package org.sopt.at.presentation.mypage

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import org.sopt.at.presentation.login.component.topbar.LoginBackTopBar

@Composable
fun MyPageRoute(
    navigateToSignIn: () -> Unit,
    navigateToHome: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: MyPageViewModel = hiltViewModel()
) {
    val userId by viewModel.userId.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.getUserInfo()
    }
    MyPageScreen(
        userId = userId,
        onLogout = {
            viewModel.logOut()
            navigateToSignIn()
        },
        onBackClick = navigateToHome,
        modifier = modifier
    )
}

@Composable
fun MyPageScreen(
    userId: String?,
    onLogout: () -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
            .padding(horizontal = 15.dp),
        containerColor = Color.Black,
        bottomBar = {
            Button(
                onClick = {
                    onLogout()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 40.dp)
                    .border(
                        width = 0.5.dp,
                        color = Color.LightGray,
                        shape = RoundedCornerShape(4.dp)
                    ),
                enabled = true,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                ),
                contentPadding = PaddingValues(vertical = 15.dp)
            ) {
                Text(
                    "로그아웃",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.LightGray
                )

            }
        }
    )
    { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
        ) {
            LoginBackTopBar(
                modifier = Modifier.padding(top = 25.dp),
                onClick = onBackClick
            )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 100.dp),
            text = "안녕하세요 : $userId 님",
            fontSize = 30.sp,
            color = Color.White,
            textAlign = TextAlign.Center
        )
    }
}
}