package org.sopt.at.presentation.home.model

import kotlinx.collections.immutable.ImmutableList

data class TabAssets(
    val rankedTitle: String,
    val unrankedTitle: String,
    val mainBanner: ImmutableList<MainBannerItem>,
    val subBanner: ImmutableList<SubBannerItem>
)
