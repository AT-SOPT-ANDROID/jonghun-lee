package org.sopt.at.presentation.home.data

import org.sopt.at.R

val homeSlideItem = listOf(
    R.drawable.img_main_banner_1,
    R.drawable.img_main_banner_2,
    R.drawable.img_main_banner_3
)

//top20을 위한 더미데이터
val homeSubDummyItem = List(20){
    index -> SubBannerItem(
        rank = index+1,
        image = homeSlideItem[index % homeSlideItem.size]
    )
}