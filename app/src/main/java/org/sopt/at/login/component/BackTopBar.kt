package org.sopt.at.login.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.at.R
import org.sopt.at.login.ui.theme.ATSOPTANDROIDTheme

@Composable
fun BackTopBar(modifier: Modifier = Modifier){
    Row(
        modifier = modifier.fillMaxWidth()
    ){
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_back_arrow),
            contentDescription = "뒤로 가기",
            tint = Color.LightGray
        )
    }
}
@Preview
@Composable
private fun TestTopBar(){
    ATSOPTANDROIDTheme {
        BackTopBar()
    }
}
