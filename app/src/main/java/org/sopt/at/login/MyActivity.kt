package org.sopt.at.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.at.login.ui.theme.ATSOPTANDROIDTheme

class MyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val userId = intent.getStringExtra("userId") ?: ""
        val userPassword = intent.getStringExtra("userPassword") ?: ""
        setContent {
            ATSOPTANDROIDTheme {
                MyScreen(userId = userId, userPassword = userPassword)
            }
        }
    }
}

@Composable
fun MyScreen(userId: String, userPassword: String){
    Text(modifier = Modifier.fillMaxSize().background(color = Color.Black).padding(top = 100.dp),
        text = "아이디 : $userId\n 비밀번호: $userPassword",
        fontSize = 30.sp,
        color = Color.White
    )
}