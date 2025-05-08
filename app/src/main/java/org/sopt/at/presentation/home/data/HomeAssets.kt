package org.sopt.at.presentation.home.data

import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList
import org.sopt.at.R
import org.sopt.at.presentation.home.model.MainBannerItem
import org.sopt.at.presentation.home.model.SubBannerItem
import org.sopt.at.presentation.home.model.TabAssets
import org.sopt.at.presentation.home.model.TabItem


val subSlideItem = persistentListOf(
    R.drawable.img_main_banner_1,
    R.drawable.img_main_banner_2,
    R.drawable.img_main_banner_3
)

val subDummyItems = List(20) { index ->
    SubBannerItem(
        rank = index + 1,
        image = subSlideItem[index % subSlideItem.size]
    )
}.toPersistentList()

// TODO: 서브 더미 바꾸기 when 분기 vs map?
val tabAssetsMap: Map<TabItem, TabAssets> = mapOf(
    TabItem.MAIN to TabAssets(
        rankedTitle = "오늘의 티빙 TOP 20",
        unrankedTitle = "지금 방영 중 콘텐츠",
        mainBanner = persistentListOf(
            MainBannerItem(R.drawable.img_main_banner_1),
            MainBannerItem(R.drawable.img_main_banner_2),
            MainBannerItem(R.drawable.img_main_banner_3)
        ),
        subBanner = subDummyItems
    ),
    TabItem.DRAMA to TabAssets(
        rankedTitle = "실시간 인기 드라마",
        unrankedTitle = "추천 인기 드라마",
        mainBanner = persistentListOf(
            MainBannerItem(R.drawable.img_drama_banner)
        ),
        subBanner = subDummyItems
    ),
    TabItem.ENTERTAINMENT to TabAssets(
        rankedTitle = "실시간 인기 예능",
        unrankedTitle ="지금 뜨는 예능" ,
        mainBanner = persistentListOf(
            MainBannerItem(R.drawable.img_enter_banner)
        ),
        subBanner = subDummyItems
    ),
    TabItem.MOVIE to TabAssets(
        rankedTitle = "실시간 인기 영화",
        unrankedTitle = "방심 금지! 스릴러 영화",
        mainBanner = persistentListOf(
            MainBannerItem(R.drawable.img_movie_banner)
        ),
        subBanner = subDummyItems
    ),
    TabItem.SPORTS to TabAssets(
        rankedTitle = "2025 KBO 중계",
        unrankedTitle = "KCC 프로농구 중계",
        mainBanner = persistentListOf(
            MainBannerItem(R.drawable.img_sports_banner_1),
            MainBannerItem(R.drawable.img_sports_banner_2)
        ),
        subBanner = subDummyItems
    ),
    TabItem.ANNIE to TabAssets(
        rankedTitle = "실시간 인기 애니메이션",
        unrankedTitle = "애니에서도 육아는 힘들어!",
        mainBanner = persistentListOf(
            MainBannerItem(R.drawable.img_annie_banner)
        ),
        subBanner = subDummyItems
    ),
    TabItem.NEWS to TabAssets(
        rankedTitle = "24시간 보도 채널 ON-AIR",
        unrankedTitle = "KBS 뉴스 클립",
        mainBanner = persistentListOf(
            MainBannerItem(R.drawable.img_news_banner)
        ),
        subBanner = subDummyItems
    ),
)