package org.sopt.at.presentation.splash.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.at.core.Route
import org.sopt.at.presentation.splash.SplashRoute

fun NavGraphBuilder.splashGraph(
    navigateToSignIn: () -> Unit,
    navigateToHome: () -> Unit,
) {
    composable<Splash> {
        SplashRoute(
            navigateToSignIn = navigateToSignIn,
            navigateToHome = navigateToHome,
        )
    }
}

@Serializable
data object Splash : Route