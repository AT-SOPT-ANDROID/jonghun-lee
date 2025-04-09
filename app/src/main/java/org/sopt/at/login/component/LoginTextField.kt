package org.sopt.at.login.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.at.R
import org.sopt.at.ui.theme.ATSOPTANDROIDTheme
import org.sopt.at.ui.theme.TvingDarkGray
import org.sopt.at.ui.theme.TvingGray

//가독성 최악의 로그인 텍스트 필드.
@Composable
fun LoginTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier,
    isPassword: Boolean = false,
    passwordVisible: Boolean = false,
    onVisibilityToggle: (() -> Unit)? = null,
    singleLine: Boolean = true,
    fontSize: Int = 18
) {
    val visual = if (isPassword && !passwordVisible) {
        PasswordVisualTransformation()
    } else {
        VisualTransformation.None
    }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(placeholder, color = TvingGray) },
        modifier = modifier.fillMaxWidth(),
        singleLine = singleLine,
        textStyle = TextStyle(fontSize = fontSize.sp),
        shape = RoundedCornerShape(8.dp),
        visualTransformation = visual,
        trailingIcon = if (isPassword && onVisibilityToggle != null) {
            {
                val visibility = if (passwordVisible) R.drawable.ic_password_visible else R.drawable.ic_password_invisible
                val description = if (passwordVisible) "비밀번호 숨기기" else "비밀번호 보기"

                Icon(
                    imageVector = ImageVector.vectorResource(visibility),
                    contentDescription = description,
                    tint = TvingGray,
                    modifier = Modifier.clickable { onVisibilityToggle() }
                )
            }
        } else null,
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = TvingDarkGray,
            focusedContainerColor = TvingDarkGray,
            unfocusedBorderColor = TvingDarkGray,
            focusedBorderColor = Color.White,
            unfocusedTextColor = Color.White,
            focusedTextColor = Color.White
        )
    )
}


@Preview(showBackground = true)
@Composable
fun TestLoginTextField(){
    ATSOPTANDROIDTheme {
        val test = remember { mutableStateOf("") }
        LoginTextField(
            value = test.value,
            onValueChange = {test.value = it},
            placeholder = "테스트",
            modifier = Modifier.fillMaxWidth().padding(top = 50.dp)
        )
    }
}

