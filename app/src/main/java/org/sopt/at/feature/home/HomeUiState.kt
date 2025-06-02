package org.sopt.at.feature.home

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import org.sopt.at.feature.home.model.MainBannerItem
import org.sopt.at.feature.home.model.SubBannerItem
import org.sopt.at.feature.home.model.TabItem

data class HomeUiState(
    val selectedTab: TabItem = TabItem.MAIN,
    val mainBannerItems: ImmutableList<MainBannerItem> = persistentListOf(),
    val rankedTitle: String = " ",
    val unrankedTitle: String = " ",
    val subBannerItems: ImmutableList<SubBannerItem> = persistentListOf(),
)
