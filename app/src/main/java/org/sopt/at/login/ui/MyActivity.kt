package org.sopt.at.login.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.at.util.SharedPreferencesManager
import org.sopt.at.ui.theme.ATSOPTANDROIDTheme

class MyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ATSOPTANDROIDTheme {
                MyScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyScreen(){
    val context = LocalContext.current
    val (userId, userPassword) = SharedPreferencesManager.getUser(context)
    Scaffold(
        modifier = Modifier.fillMaxSize().background(color = Color.Black).padding(horizontal = 15.dp),
        containerColor = Color.Black,
        bottomBar ={
            Button(
                onClick = {
                    SharedPreferencesManager.logOut(context)
                    val intent = Intent(context, SignInActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    }
                    context.startActivity(intent)

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
            Text(modifier = Modifier.fillMaxWidth().padding(top = 100.dp),
                text = "안녕하세요 : $userId 님",
                fontSize = 30.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
    }
}