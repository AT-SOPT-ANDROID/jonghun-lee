package org.sopt.at.feature.splash.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.at.core.navigation.Route
import org.sopt.at.feature.splash.SplashRoute

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