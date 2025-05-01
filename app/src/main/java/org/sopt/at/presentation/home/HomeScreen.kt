package org.sopt.at.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import org.sopt.at.navigation.NavItem
import org.sopt.at.presentation.home.component.HomeMainBanner
import org.sopt.at.presentation.home.component.HomeSubBanner
import org.sopt.at.presentation.home.component.HomeTabLayout
import org.sopt.at.presentation.home.component.HomeTopBar
import org.sopt.at.presentation.home.data.homeSlideItem
import org.sopt.at.presentation.home.data.homeSubDummyItem

@Composable
fun HomeScreen(rootNavController: NavHostController) {
    Column() {
        HomeTopBar(modifier = Modifier,
            onItemClick = {
            rootNavController.navigate(NavItem.MY)
        })
        // TODO: Sticky Header 구현
        HomeTabLayout()
        LazyColumn(verticalArrangement = Arrangement.spacedBy(15.dp),
            contentPadding = PaddingValues(vertical = 10.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            item { HomeMainBanner(slideList = homeSlideItem) }
            item {
                HomeSubBanner(
                    title = "오늘의 티빙 TOP 20",
                    slideList = homeSubDummyItem,
                    isRank = true
                )
            }

            item {
                HomeSubBanner(
                    title = "지금 방영 중인 콘텐츠",
                    slideList = homeSubDummyItem,
                    isRank = false
                )
            }

        }
    }
}