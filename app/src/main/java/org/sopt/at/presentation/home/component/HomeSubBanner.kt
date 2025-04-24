package org.sopt.at.presentation.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.at.presentation.home.data.SubBannerItem

@Composable
fun HomeSubBanner(title: String, slideList: List<SubBannerItem>,isRank: Boolean ) {
    Row(modifier=Modifier.fillMaxWidth().padding(horizontal = 15.dp, vertical = 5.dp)) {
        Text(
            text = title,
            fontSize = 20.sp,
            color = Color.White
        )
    }
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(slideList) { item ->
            HomeSubSlideItem(subBanner = item, isRank = isRank)
        }
    }
}