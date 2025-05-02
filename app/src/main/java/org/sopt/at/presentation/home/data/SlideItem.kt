package org.sopt.at.presentation.home.data

import org.sopt.at.R

val homeSlideItem = listOf(
    R.drawable.img_main_banner_1,
    R.drawable.img_main_banner_2,
    R.drawable.img_main_banner_3
)
val dramaSlideItem = R.drawable.img_drama_banner
val enterTainMentSlideItem = R.drawable.img_enter_banner
val moiveSlideItem = R.drawable.img_movie_banner
val sportsSlideItem = listOf(
    R.drawable.img_sports_banner_1,
    R.drawable.img_sports_banner_2
)
val annieSlideItem = R.drawable.img_annie_banner
val newsSlideItem = R.drawable.img_news_banner

//top20을 위한 더미데이터
val homeSubDummyItem = List(20) { index ->
    SubBannerItem(
        rank = index + 1,
        image = homeSlideItem[index % homeSlideItem.size]
    )
}