package org.sopt.at.presentation.mypage.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.at.core.Route
import org.sopt.at.presentation.mypage.MyPageRoute

fun NavController.navigateToMyPage(navOptions: NavOptions) {
    navigate(MyPage, navOptions)
}

fun NavGraphBuilder.myPageGraph(
    naviGateToSignIn: () -> Unit,
    naviGateToHome: () -> Unit,
    modifier: Modifier = Modifier,
) {
    composable<MyPage> {
        MyPageRoute(
            navigateToSignIn = naviGateToSignIn,
            navigateToHome = naviGateToHome,
            modifier = modifier
        )
    }
}


@Serializable
data object MyPage : Route