package org.sopt.at.presentation.login.ui.signup.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.at.core.Route
import org.sopt.at.presentation.login.ui.signup.SignUpRoute

@Composable
fun NavController.navigateToSignUp(navOptions: NavOptions) {
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
            popBackStack = popBackStack,
            navigateToSignIn = navigateToSignIn
        )
    }
}


@Serializable
data object SignUp : Route