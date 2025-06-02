package org.sopt.at.feature.login.ui.signin.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.at.core.navigation.Route
import org.sopt.at.feature.login.ui.signin.SignInRoute


fun NavController.navigateToSignIn(navOptions: NavOptions? = null) {
    navigate(SignIn, navOptions)
}

fun NavGraphBuilder.signInGraph(
    modifier: Modifier = Modifier,
    navigateToSingUp: () -> Unit,
    navigateToHome: () -> Unit
) {

    composable<SignIn> {
        SignInRoute(
            onSignInClick = navigateToHome,
            onSignUpClick = navigateToSingUp
        )
    }
}

@Serializable
data object SignIn : Route