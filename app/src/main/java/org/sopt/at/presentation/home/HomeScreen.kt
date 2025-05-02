package org.sopt.at.presentation.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import org.sopt.at.presentation.home.component.HomeMainBanner
import org.sopt.at.presentation.home.component.HomeSubBanner
import org.sopt.at.presentation.home.component.HomeTabLayout
import org.sopt.at.presentation.home.component.HomeTopBar
import org.sopt.at.presentation.home.data.TabItem

@Composable
fun HomeRoute(
    modifier: Modifier = Modifier,
    navigateToMyPage: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState
    HomeScreen(
        modifier = modifier,
        uiState = uiState,
        onTabSelected = viewModel::onTabSelected,
        navigateToMyPage = navigateToMyPage,
    )
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    uiState: HomeUiState,
    onTabSelected: (TabItem) -> Unit,
    navigateToMyPage: () -> Unit,
) {
    Column(modifier = modifier
        .background(Color.Black)) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(15.dp),
            contentPadding = PaddingValues(vertical = 10.dp),
            modifier = Modifier
                .fillMaxSize()
        ) {
            item {
                HomeTopBar(
                    modifier = Modifier,
                    onItemClick = navigateToMyPage
                )
            }
            stickyHeader {
                HomeTabLayout(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Black)
                        .padding(10.dp),
                    selectedTab = uiState.selectedTab,
                    onTabSelected = onTabSelected,
                )

            }
            item { HomeMainBanner(slideList = uiState.mainBannerList) }
            item {
                HomeSubBanner(
                    title = uiState.rankedTitle,
                    slideList = uiState.subBannerItems,
                    isRank = true
                )
            }

            item {
                HomeSubBanner(
                    title = uiState.unrankedTitle,
                    slideList = uiState.subBannerItems,
                    isRank = false
                )
            }
        }
    }
}
