package org.sopt.at.login.component.topbar

import androidx.activity.ComponentActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import org.sopt.at.R

@Composable
fun LoginBackTopBar(modifier: Modifier = Modifier){
    val context = LocalContext.current
    Row(
        modifier = modifier.fillMaxWidth()
    ){
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_back_arrow),
            contentDescription = "뒤로 가기",
            tint = Color.LightGray,
            modifier = Modifier.clickable {
                (context as? ComponentActivity)?.finish()
            }
        )
    }
}
