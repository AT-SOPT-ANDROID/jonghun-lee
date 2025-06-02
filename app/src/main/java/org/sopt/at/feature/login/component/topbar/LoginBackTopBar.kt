package org.sopt.at.feature.login.component.topbar

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import org.sopt.at.R
import org.sopt.at.core.component.noRippleClickable

@Composable
fun LoginBackTopBar(
    onClick:()->Unit,
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier.fillMaxWidth()
    ){
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_back_arrow),
            contentDescription = "뒤로 가기",
            tint = Color.LightGray,
            modifier = Modifier.noRippleClickable {
                onClick()
            }
        )
    }
}
