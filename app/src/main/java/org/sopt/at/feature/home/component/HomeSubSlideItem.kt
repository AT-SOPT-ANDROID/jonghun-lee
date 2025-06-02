package org.sopt.at.feature.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.at.feature.home.model.SubBannerItem

//티빙 top 20, 지금 방영 중인 콘텐츠에 들어갈 아이템
@Composable
fun HomeSubSlideItem(subBanner: SubBannerItem, isRank: Boolean = true) {
    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.Bottom
    ) {
        if (isRank) {
            Text(
                text = subBanner.rank.toString(),
                color = Color.White,
                fontSize = 70.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                modifier = Modifier
                    .height(70.dp)
                    .graphicsLayer { scaleY = 1.3f },
                letterSpacing = (-1).sp
            )
        }
        Image(
            painter = painterResource(id = subBanner.image),
            contentDescription = "subBannerImage",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(120.dp)
                .height(165.dp)
                .clip(RoundedCornerShape(5.dp))
        )


    }
}



