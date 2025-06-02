package org.sopt.at.feature.main

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import org.sopt.at.R
import org.sopt.at.core.navigation.MainTabRoute
import org.sopt.at.core.navigation.Route
import org.sopt.at.feature.history.navigation.History
import org.sopt.at.feature.home.navigation.Home
import org.sopt.at.feature.live.navigation.Live
import org.sopt.at.feature.search.navigation.Search
import org.sopt.at.feature.shorts.navigation.Shorts

enum class MainTab(
    @DrawableRes val icon: Int,
    internal val contentDescription : String,
    val route: MainTabRoute
) {
    HOME(
        icon = R.drawable.ic_bottom_home,
        contentDescription = "HOME",
        route = Home
    ),
    SHORTS(
        icon = R.drawable.ic_bottom_shorts,
        contentDescription = "Shorts",
        route = Shorts
    ),
    LIVE(
        icon = R.drawable.ic_bottom_live,
        contentDescription = "LIVE",
        route = Live
    ),
    SEARCH(
        icon = R.drawable.ic_bottom_search,
        contentDescription = "SEARCH",
        route = Search
    ),
    HISTORY(
        icon = R.drawable.ic_bottom_history,
        contentDescription = "HISTORY",
        route = History
    );

    companion object {
        @Composable
        fun find(predicate: @Composable (MainTabRoute) -> Boolean): MainTab? {
            return entries.find { predicate(it.route) }
        }

        @Composable
        fun contains(predicate: @Composable (Route) -> Boolean): Boolean {
            return entries.map { it.route }.any { predicate(it) }
        }
    }
}


