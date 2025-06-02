package org.sopt.at.feature.login.ui.signup.ui.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.at.core.navigation.Route
import org.sopt.at.feature.login.ui.signup.SignUpRoute

fun NavController.navigateToSignUp(navOptions: NavOptions? = null) {
    navigate(SignUp, navOptions)

}

fun NavGraphBuilder.signUpGraph(
    modifier: Modifier,
    navigateToSignIn: () -> Unit,
    popBackStack: () -> Unit,
) {
    composable<SignUp> {
        SignUpRoute(
            modifier = modifier,
            onBackClick = popBackStack,
            navigateToSignIn = navigateToSignIn
        )
    }
}


@Serializable
data object SignUp : Route