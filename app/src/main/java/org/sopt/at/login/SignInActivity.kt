package org.sopt.at.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.at.login.component.BackTopBar
import org.sopt.at.login.component.LoginTextField
import org.sopt.at.login.ui.theme.ATSOPTANDROIDTheme

class SignInActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ATSOPTANDROIDTheme {
                LoginScreen(
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun LoginScreen(){
    val context = LocalContext.current
    val signedId = remember { mutableStateOf("") }
    val signedPassword = remember { mutableStateOf("") }
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            signedId.value = result.data?.getStringExtra("userId") ?: ""
            signedPassword.value = result.data?.getStringExtra("userPassword") ?: ""
        }
    }
    val userId = remember { mutableStateOf("") }
    val userPassword = remember { mutableStateOf("") }
    val passwordVisible = remember { mutableStateOf(false) }
    Column (
        modifier = Modifier.fillMaxSize().background(Color.Black).padding(horizontal = 15.dp)
    ){
        BackTopBar(modifier = Modifier.padding(top = 25.dp))
        Text(
            modifier = Modifier.padding(top = 40.dp),
            text = "TVING ID 로그인",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        LoginTextField(
            value = userId.value,
            onValueChange = {userId.value = it},
            placeholder = "아이디",
            modifier = Modifier.padding(top = 25.dp)

        )
        LoginTextField(
            value = userPassword.value,
            onValueChange = {userPassword.value = it},
            placeholder = "비밀번호",
            modifier = Modifier.padding(top = 15.dp),
            isPassword = true,
            passwordVisible = passwordVisible.value,
            onVisibilityToggle = {passwordVisible.value = !passwordVisible.value}
        )

        Button(
            onClick = {
                if (userId.value == signedId.value && userPassword.value == signedPassword.value){
                    val intent = Intent(context, MyActivity::class.java).apply {
                        putExtra("userId", userId.value)
                        putExtra("userPassword", userPassword.value)
                    }
                    context.startActivity(intent)
                }else{
                    Toast.makeText(context, "로그인 실패", Toast.LENGTH_SHORT).show()
                }
            } ,
            modifier = Modifier.fillMaxWidth().padding(top = 25.dp, bottom = 30.dp),
            enabled = true,
            shape = RoundedCornerShape(4.dp),
            contentPadding = PaddingValues(vertical = 15.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.DarkGray,
                contentColor = Color.White
            )
        ) {
            Text(
                text = "로그인하기",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                color = Color.LightGray
            )
        }
        Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceAround) {
            Text(
                text = "아이디 찾기",
                color = Color.LightGray,
                fontSize = 16.sp
            )
            VerticalDivider(
                modifier = Modifier.height(24.dp),
                color = Color.DarkGray
            )
            Text(
                text = "비밀번호 찾기",
                color = Color.LightGray,
                fontSize = 16.sp
            )
            VerticalDivider(
                modifier = Modifier.height(24.dp),
                color = Color.DarkGray
            )
            Text(
                text = "회원가입",
                color = Color.LightGray,
                fontSize = 16.sp,
                modifier = Modifier.clickable {
                    launcher.launch(Intent(context, SignUpActivity::class.java))
                }
            )
        }
        GooglePolicyText(modifier = Modifier.padding(top = 30.dp))
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
        color = Color.LightGray,
        fontSize = 13.sp,
        textAlign = TextAlign.Center,
        modifier = modifier.fillMaxWidth()
    )
}
