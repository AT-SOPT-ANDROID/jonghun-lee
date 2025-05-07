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
import kotlinx.collections.immutable.ImmutableList
import org.sopt.at.presentation.home.model.MainBannerItem

@Composable
fun HomeMainBanner(
    slideList: ImmutableList<MainBannerItem>,
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
            HomeMainSlideItem(image = slideList[page].image)
        }

    }
}