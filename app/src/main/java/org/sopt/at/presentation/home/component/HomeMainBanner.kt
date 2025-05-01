package org.sopt.at.presentation.home.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeMainBanner(
    slideList: List<Int>,
    modifier: Modifier = Modifier
) {
    val slideState = rememberPagerState(
        initialPage = 0,
        pageCount = { slideList.size }
    )

    Column(modifier = modifier) {
        HorizontalPager(
            state = slideState,
            pageSpacing = 12.dp,
            contentPadding = PaddingValues(horizontal = 15.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
        ) { page ->
            HomeMainSlideItem(image = slideList[page])
        }

    }
}