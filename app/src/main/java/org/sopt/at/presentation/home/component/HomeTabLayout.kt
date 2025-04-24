package org.sopt.at.presentation.home.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// TODO: Sticky Header 구현
@Composable
fun HomeTabLayout() {
    val tabs = listOf("드라마","예능","영화","스포츠","애니","뉴스")
    ScrollableTabRow(
        selectedTabIndex = 0,
        modifier = Modifier.fillMaxWidth(),
        edgePadding = 0.dp,
        containerColor = Color.Black,
        indicator = {},
        divider = {}
    ) {
        tabs.forEach { title ->
            Tab(
                selected = false,
                onClick ={},
                enabled = false,
                text = {
                    Text(
                        text = title,
                        fontSize = 20.sp,
                        color = Color.White,

                    )
                }
            )
        }
    }
}