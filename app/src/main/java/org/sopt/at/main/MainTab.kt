package org.sopt.at.main

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import org.sopt.at.R
import org.sopt.at.core.MainTabRoute
import org.sopt.at.core.Route
import org.sopt.at.presentation.history.navigation.History
import org.sopt.at.presentation.home.navigation.Home
import org.sopt.at.presentation.live.navigation.Live
import org.sopt.at.presentation.search.navigation.Search
import org.sopt.at.presentation.shorts.navigation.Shorts

enum class MainTab(@DrawableRes val icon: Int, internal val contentDescription : String, val route: MainTabRoute) {
    HOME(icon = R.drawable.ic_bottom_home, contentDescription = "HOME", route = Home),
    SHORTS(icon = R.drawable.ic_bottom_shorts, contentDescription = "Shorts", route = Shorts),
    LIVE(icon = R.drawable.ic_bottom_live, contentDescription = "LIVE", route = Live),
    SEARCH(icon = R.drawable.ic_bottom_search, contentDescription = "SEARCH", route = Search),
    HISTORY(icon = R.drawable.ic_bottom_history, contentDescription = "HISTORY", route = History);

    companion object {
        @Composable
        fun find(predicate: @Composable (Route) -> Boolean): MainTab? {
            return entries.find { predicate(it.route) }
        }

        @Composable
        fun contains(predicate: @Composable (Route) -> Boolean): Boolean {
            return entries.map { it.route }.any { predicate(it) }
        }
    }
}


