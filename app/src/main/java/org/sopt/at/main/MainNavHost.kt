package org.sopt.at.main

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import org.sopt.at.presentation.login.ui.signin.navigation.signInGraph
import org.sopt.at.presentation.login.ui.signup.ui.navigation.signUpGraph
import org.sopt.at.presentation.mypage.navigation.myPageGraph
import org.sopt.at.presentation.history.navigation.historyGraph
import org.sopt.at.presentation.home.navigation.homeGraph
import org.sopt.at.presentation.live.navigation.liveGraph
import org.sopt.at.presentation.search.navigation.searchGraph
import org.sopt.at.presentation.shorts.navigation.shortsGraph
import org.sopt.at.presentation.splash.navigation.splashGraph

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