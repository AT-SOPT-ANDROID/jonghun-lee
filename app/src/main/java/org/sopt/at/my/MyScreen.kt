package org.sopt.at.my

import android.app.Activity
import android.content.Intent
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
import androidx.navigation.NavHostController
import org.sopt.at.login.component.topbar.LoginBackTopBar
import org.sopt.at.login.ui.signin.SignInActivity
import org.sopt.at.navigation.NavItem

@Composable
fun MyScreen(viewModel: MyViewModel, navController: NavHostController) {
    val userId by viewModel.userId.collectAsState()
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        viewModel.getUserInfo("")
    }
    Scaffold(
        modifier = Modifier.fillMaxSize().background(color = Color.Black).padding(horizontal = 15.dp),
        containerColor = Color.Black,
        bottomBar ={
            Button(
                onClick = {
                   viewModel.logOut()
                    context.startActivity(Intent(context, SignInActivity::class.java))
                    (context as? Activity)?.finish()

                },
                modifier = Modifier.fillMaxWidth().padding(vertical = 40.dp)
                    .border(width = 0.5.dp, color = Color.LightGray, shape = RoundedCornerShape(4.dp)),
                enabled = true,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White),
                contentPadding = PaddingValues(vertical = 15.dp)
            ) {
                Text("로그아웃",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.LightGray
                )

            }
        }
    )
    {innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).fillMaxSize(),
            ) {
            LoginBackTopBar(modifier = Modifier.padding(top = 25.dp),
                onClick = {navController.navigate(NavItem.MAIN){
                    popUpTo("main") { inclusive = true }
                    launchSingleTop = true
                } })
            Text(modifier = Modifier.fillMaxWidth().padding(top = 100.dp),
                text = "안녕하세요 : $userId 님",
                fontSize = 30.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
    }
}