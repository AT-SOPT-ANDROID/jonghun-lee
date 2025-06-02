package org.sopt.at.feature.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import org.sopt.at.feature.history.navigation.navigateToHistory
import org.sopt.at.feature.home.navigation.navigateToHome
import org.sopt.at.feature.live.navigation.navigateToLive
import org.sopt.at.feature.login.ui.signin.navigation.navigateToSignIn
import org.sopt.at.feature.login.ui.signup.ui.navigation.navigateToSignUp
import org.sopt.at.feature.mypage.navigation.navigateToMyPage
import org.sopt.at.feature.search.navigation.navigateToSearch
import org.sopt.at.feature.shorts.navigation.navigateToShorts
import org.sopt.at.feature.splash.navigation.Splash

class MainNavigator(
    val navController: NavHostController
) {
    val startDestination = Splash
    private val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val currentTab: MainTab?
        @Composable get() = MainTab.find { tab ->
            currentDestination?.hasRoute(tab::class) == true
        }


    //바텀 네비게이션 화면 이동
    fun navigate(tab: MainTab) {
        MainTab.HOME.route.let {
            val navOptions = navOptions {
                popUpTo(it) {
                    if (tab == MainTab.HOME) {
                        inclusive = true
                    } else {
                        saveState = true
                    }
                }
                launchSingleTop = true
                if (tab != MainTab.HOME) {
                    restoreState = true
                }
            }

            when (tab) {
                MainTab.HOME -> navController.navigateToHome(navOptions)
                MainTab.SHORTS -> navController.navigateToShorts(navOptions)
                MainTab.LIVE -> navController.navigateToLive(navOptions)
                MainTab.SEARCH -> navController.navigateToSearch(navOptions)
                MainTab.HISTORY -> navController.navigateToHistory(navOptions)
            }
        }
    }

    fun navigateToHome() {
        navController.navigateToHome(
            navOptions {
                popUpTo(navController.graph.id) { inclusive = true }
            }
        )
    }


    fun navigateToSignUp() {
        navController.navigateToSignUp(
            navOptions {
                popUpTo(navController.graph.id) { inclusive = true }
            }
        )
    }

    fun navigateToSignIn() {
        navController.navigateToSignIn(
            navOptions {
                popUpTo(navController.graph.id) { inclusive = true }
            }
        )
    }

    fun navigateToMyPage() {
        navController.navigateToMyPage(
            navOptions {
                launchSingleTop = true
            }
        )

    }

    fun navigateBack() {
        navController.popBackStack()
    }


    @Composable
    fun showBottomBar() = MainTab.contains {
        currentDestination?.hasRoute(it::class) == true
    }
}

@Composable
fun rememberMainNavigator(
    navController: NavHostController = rememberNavController(),
): MainNavigator = remember(navController) {
    MainNavigator(navController)
}