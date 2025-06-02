package org.sopt.at.feature.home.model

import kotlinx.collections.immutable.persistentListOf

enum class TabItem(
    val title: String
) {
    MAIN("전체"),
    DRAMA("드라마"),
    ENTERTAINMENT("예능"),
    MOVIE("영화"),
    SPORTS("스포츠"),
    ANNIE("애니"),
    NEWS("뉴스");

    companion object {
        val visibleTabs = persistentListOf(
            DRAMA, ENTERTAINMENT, MOVIE, SPORTS, ANNIE, NEWS
        )
    }
}