package org.sopt.at.presentation.search.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.at.core.MainTabRoute
import org.sopt.at.presentation.search.SearchRoute

fun NavController.navigateToSearch(navOptions: NavOptions){
    navigate(Search, navOptions)
}
fun NavGraphBuilder.searchGraph(modifier: Modifier = Modifier){
    composable<Search>{
        SearchRoute(modifier = modifier)
    }
}
@Serializable
data object Search: MainTabRoute