package org.sopt.at.navigation

import androidx.annotation.DrawableRes
import org.sopt.at.R

enum class BottomNavItem(val route: String, @DrawableRes val icon: Int, val title: String) {
    Home("home", R.drawable.ic_bottom_home, "HOME"),
    Shorts("shorts", R.drawable.ic_bottom_shorts, "Shorts"),
    Live("live", R.drawable.ic_bottom_live, "LIVE"),
    Search("search", R.drawable.ic_bottom_search, "SEARCH"),
    History("history", R.drawable.ic_bottom_history,"HISTORY")
}