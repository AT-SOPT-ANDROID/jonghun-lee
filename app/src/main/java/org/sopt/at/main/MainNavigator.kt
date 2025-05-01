package org.sopt.at.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import org.sopt.at.presentation.login.ui.signin.navigation.SignIn
import org.sopt.at.presentation.login.ui.signup.ui.navigation.SignUp
import org.sopt.at.presentation.mypage.navigation.MyPage
import org.sopt.at.presentation.history.navigation.navigateToHistory
import org.sopt.at.presentation.home.navigation.navigateToHome
import org.sopt.at.presentation.live.navigation.navigateToLive
import org.sopt.at.presentation.search.navigation.navigateToSearch
import org.sopt.at.presentation.shorts.navigation.navigateToShorts
import org.sopt.at.presentation.splash.navigation.Splash

class MainNavigator(
    val navController: NavHostController
) {
    val startDestination = Splash
    private val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val currentTab: MainTab?
        @Composable get() = MainTab.entries.find { tab ->
            currentDestination?.route == tab.route::class.qualifiedName
        }

    //바텀 네비게이션 화면 이동
    fun navigate(tab: MainTab) {
        val navOptions = navOptions {
            popUpTo(MainTab.HOME.route) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
        when (tab) {
            MainTab.HOME -> {
                navController.navigateToHome(navOptions)
            }

            MainTab.SHORTS -> {
                navController.navigateToShorts(navOptions)
            }

            MainTab.LIVE -> {
                navController.navigateToLive(navOptions)
            }

            MainTab.SEARCH -> {
                navController.navigateToSearch(navOptions)
            }

            MainTab.HISTORY -> {
                navController.navigateToHistory(navOptions)
            }
        }
    }

    fun navigateToHome(navOptions: NavOptions? = null) {
        navController.navigateToHome(
            navOptions ?: navOptions {
                popUpTo(navController.graph.id) {
                    inclusive = true
                }
            }
        )
    }


    fun navigateToSignUp() {
        navController.navigate(SignUp) {
            popUpTo(navController.graph.id) {
                inclusive = true
            }
        }
    }

    fun navigateToSignIn() {
        navController.navigate(SignIn) {
            popUpTo(navController.graph.id) {
                inclusive = true
            }
        }
    }

    fun navigateToMyPage() {
        navController.navigate(MyPage)
    }

    fun popBackStack() {
        navController.popBackStack()
    }

    @Composable
    fun showBottomNav(): Boolean {
        val currentRoute = currentDestination?.route ?: return false
        return MainTab.entries.any { tab ->
            currentRoute == tab.route::class.qualifiedName
        }
    }
}
@Composable
fun rememberMainNavigator(
    navController: NavHostController = rememberNavController(),
): MainNavigator = remember(navController) {
    MainNavigator(navController)
}