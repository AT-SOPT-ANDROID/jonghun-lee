package org.sopt.at.presentation.shorts.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.at.core.MainTabRoute
import org.sopt.at.presentation.shorts.ShortsRoute

fun NavController.navigateToShorts(navOptions: NavOptions){
    navigate(Shorts,navOptions)
}
fun NavGraphBuilder.shortsGraph(
    modifier: Modifier = Modifier
){
    composable<Shorts>{
        ShortsRoute(modifier = modifier)
    }
}
@Serializable
data object Shorts: MainTabRoute