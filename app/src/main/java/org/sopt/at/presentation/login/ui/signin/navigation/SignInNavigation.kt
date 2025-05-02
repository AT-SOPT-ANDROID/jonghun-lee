package org.sopt.at.presentation.login.ui.signin.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.at.core.Route
import org.sopt.at.presentation.login.ui.signin.SignInRoute


fun NavController.navigateToSignIn(navOptions: NavOptions) {
    navigate(SignIn, navOptions)
}

fun NavGraphBuilder.signInGraph(
    modifier: Modifier = Modifier,
    navigateToSingUp: () -> Unit,
    navigateToHome: () -> Unit
) {

    composable<SignIn> {
        SignInRoute(
            navigateToHome = navigateToHome,
            navigateToSignUp = navigateToSingUp
        )
    }
}

@Serializable
data object SignIn : Route