package org.sopt.at.feature.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.sopt.at.feature.home.data.*
import org.sopt.at.feature.home.model.TabItem
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _uiState = mutableStateOf(HomeUiState())
    val uiState: State<HomeUiState> = _uiState

    init {
        onTabSelected(TabItem.MAIN)
    }

    fun onTabSelected(tab: TabItem) {
        val assets = tabAssetsMap[tab] ?: return
        _uiState.value = HomeUiState(
            selectedTab = tab,
            rankedTitle = assets.rankedTitle,
            unrankedTitle = assets.unrankedTitle,
            mainBannerItems = assets.mainBanner,
            subBannerItems = assets.subBanner
        )
    }
}
