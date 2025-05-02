package org.sopt.at.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.sopt.at.presentation.home.data.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _uiState = mutableStateOf(HomeUiState())
    val uiState: State<HomeUiState> = _uiState

    init {
        onTabSelected(TabItem.MAIN)
    }

    // TODO: 탭별 데이터 변경..
    fun onTabSelected(tab: TabItem) {
        val rankedTitle = when (tab) {
            TabItem.MAIN -> "오늘의 티빙 TOP 20"
            TabItem.DRAMA -> "실시간 인기 드라마"
            TabItem.ENTERTAINMENT -> "실시간 인기 예능"
            TabItem.MOVIE -> "실시간 인기 영화"
            TabItem.SPORTS -> "2025 KBO 중계"
            TabItem.ANNIE -> "실시간 인기 애니메이션"
            TabItem.NEWS -> "24시간 보도 채널 ON-AIR"
        }

        val unrankedTitle = when (tab) {
            TabItem.MAIN -> "지금 방영 중인 콘텐츠"
            TabItem.DRAMA -> "추천 인기 드라마"
            TabItem.ENTERTAINMENT -> "지금 뜨는 예능"
            TabItem.MOVIE -> "방심 금지! 스릴러 영화"
            TabItem.SPORTS -> "KCC 프로농구 중계"
            TabItem.ANNIE -> "애니에서도 육아는 힘들어!"
            TabItem.NEWS -> "KBS 뉴스 클립"
        }

        // 탭에 따라 메인 배너 이미지 선택 (단일일 경우 listOf()로 래핑)
        val mainBannerList = when (tab) {
            TabItem.MAIN -> homeSlideItem
            TabItem.DRAMA -> listOf(dramaSlideItem)
            TabItem.ENTERTAINMENT -> listOf(enterTainMentSlideItem)
            TabItem.MOVIE -> listOf(moiveSlideItem)
            TabItem.SPORTS -> sportsSlideItem
            TabItem.ANNIE -> listOf(annieSlideItem)
            TabItem.NEWS -> listOf(newsSlideItem)
        }
        // TODO: 이것 또한 나중에 수정..
        val subBannerItems = homeSubDummyItem

        _uiState.value = HomeUiState(
            selectedTab = tab,
            mainBannerList = mainBannerList,
            rankedTitle = rankedTitle,
            unrankedTitle = unrankedTitle,
            subBannerItems = subBannerItems
        )
    }
}
