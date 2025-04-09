package org.sopt.at.login.ui

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.at.util.SharedPreferencesManager
import org.sopt.at.login.component.LoginBackTopBar
import org.sopt.at.login.component.LoginTextField
import org.sopt.at.ui.theme.ATSOPTANDROIDTheme
import org.sopt.at.ui.theme.TvingGray
import org.sopt.at.ui.theme.TvingRed

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ATSOPTANDROIDTheme {
                SignUpScreen()
                }
            }
        }
    }

@Preview(showBackground = true)
@Composable
fun SignUpScreen() {
    val userId = remember { mutableStateOf("") }
    val userPassword = remember { mutableStateOf("") }
    val isPassword = remember { mutableStateOf(false) }
    val passwordVisible = remember { mutableStateOf(false) }
    val context = LocalContext.current


    Scaffold(
        modifier = Modifier.fillMaxSize().background(color = Color.Black).padding(horizontal = 15.dp),
        containerColor = Color.Black,
        bottomBar = {
            val isButtonEnabled = if (!isPassword.value) {
                userId.value.isNotBlank()
            } else {
                userPassword.value.isNotBlank()
            }

            Button(
                onClick = {
                    if (!isPassword.value){
                        val idPattern = Regex("^[a-z0-9]{6,12}$")
                        if (!idPattern.matches(userId.value)){
                            Toast.makeText(context,"아이디 형식이 이상해요.", Toast.LENGTH_SHORT).show()
                            return@Button
                        }
                        isPassword.value = true
                    }else{
                        val pwPattern = Regex("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#\$%^&*])[A-Za-z\\d~!@#\$%^&*]{8,15}\$")
                        if (!pwPattern.matches(userPassword.value)){
                            Toast.makeText(context,"비밀번호 형식이 이상해요.", Toast.LENGTH_SHORT).show()
                            return@Button
                        }
                        SharedPreferencesManager.saveUser(context, userId.value, userPassword.value)
//                        val resultIntent = Intent().apply {
//                            putExtra("userId", userId.value)
//                            putExtra("userPassword", userPassword.value)
//                        }
//                        (context as? Activity)?.setResult(Activity.RESULT_OK, resultIntent)
                        (context as? Activity)?.finish()
                    }
                },
                modifier = Modifier.fillMaxWidth().padding(vertical = 40.dp)
                    .border(width = 0.5.dp, color = Color.LightGray, shape = RoundedCornerShape(4.dp)),
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
                Text("다음",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.LightGray)

            }
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).fillMaxSize())
        {
            LoginBackTopBar(modifier = Modifier.padding(top = 25.dp))

            Text(
                modifier = Modifier.fillMaxWidth().padding(top = 30.dp),
                text = if(!isPassword.value) "아이디를 입력해주세요." else "비밀번호를 입력해주세요.",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center
            )
            if(!isPassword.value) {
                LoginTextField(
                    value = userId.value,
                    onValueChange = { userId.value = it },
                    placeholder = "아이디",
                    modifier = Modifier.padding(top = 20.dp),
                )
                Text(
                    text = "영문 소문자 또는 영문 소문, 숫자 조합 6~12자리",
                    color = TvingGray,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(top = 10.dp)
                )
            }else{
                LoginTextField(
                    value = userPassword.value,
                    onValueChange = { userPassword.value = it },
                    placeholder = "비밀번호",
                    modifier = Modifier.padding(top = 20.dp),
                    isPassword = true,
                    passwordVisible = passwordVisible.value,
                    onVisibilityToggle = {passwordVisible.value = !passwordVisible.value}
                )
                Text(
                    text = "영문 숫자, 특수문자(~!@#$%^&*)조합 8~15자리",
                    color = TvingGray,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(top = 10.dp)
                )
            }

        }
    }
}