package org.sopt.at.presentation.home

import org.sopt.at.presentation.home.data.SubBannerItem
import org.sopt.at.presentation.home.data.TabItem
import org.sopt.at.presentation.home.data.homeSlideItem
import org.sopt.at.presentation.home.data.homeSubDummyItem

data class HomeUiState(
    val selectedTab: TabItem = TabItem.MAIN,
    val mainBannerList: List<Int> = homeSlideItem,
    val rankedTitle: String = " ",
    val unrankedTitle: String = " ",
    val subBannerItems: List<SubBannerItem> = homeSubDummyItem,
)
