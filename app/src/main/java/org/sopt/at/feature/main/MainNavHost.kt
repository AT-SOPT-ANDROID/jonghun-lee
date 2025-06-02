package org.sopt.at.feature.main

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import org.sopt.at.feature.login.ui.signin.navigation.signInGraph
import org.sopt.at.feature.login.ui.signup.ui.navigation.signUpGraph
import org.sopt.at.feature.mypage.navigation.myPageGraph
import org.sopt.at.feature.history.navigation.historyGraph
import org.sopt.at.feature.home.navigation.homeGraph
import org.sopt.at.feature.live.navigation.liveGraph
import org.sopt.at.feature.search.navigation.searchGraph
import org.sopt.at.feature.shorts.navigation.shortsGraph
import org.sopt.at.feature.splash.navigation.splashGraph

@Composable
fun MainNavHost(
    navigator: MainNavigator,
    modifier: Modifier = Modifier
) {
    NavHost(
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None },
        navController = navigator.navController,
        startDestination = navigator.startDestination
    ) {
        homeGraph(
            modifier = modifier,
            navigateToMyPage = navigator::navigateToMyPage
        )
        shortsGraph(
            modifier = modifier
        )
        liveGraph(
            modifier = modifier
        )
        searchGraph(
            modifier = modifier
        )
        historyGraph(
            modifier = modifier
        )
        signInGraph(
            modifier = modifier,
            navigateToHome = navigator::navigateToHome,
            navigateToSingUp = navigator::navigateToSignUp
        )
        signUpGraph(
            modifier = modifier,
            popBackStack = navigator::navigateBack,
            navigateToSignIn = navigator::navigateToSignIn
        )
        myPageGraph(
            modifier = modifier,
            naviGateToSignIn = navigator::navigateToSignIn,
            naviGateToBack = navigator::navigateBack
        )
        splashGraph(
            navigateToSignIn = navigator::navigateToSignIn,
            navigateToHome = navigator::navigateToHome
        )
    }
}