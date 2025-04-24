package org.sopt.at.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.sopt.at.navigation.BottomNavItem
import org.sopt.at.navigation.BottomNavigation
import org.sopt.at.presentation.history.HistoryScreen
import org.sopt.at.presentation.home.HomeScreen
import org.sopt.at.presentation.live.LiveScreen
import org.sopt.at.presentation.search.SearchScreen
import org.sopt.at.presentation.shorts.ShortsScreen

@Composable
fun MainScreen(rootNavController : NavHostController) {
    val bottomNavController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize().navigationBarsPadding(),
        bottomBar = { BottomNavigation(bottomNavController) }
    ) { innerPadding->
        NavHost(
            navController = bottomNavController,
            startDestination = BottomNavItem.Home.route,
            modifier = Modifier.background(Color.Black).fillMaxSize().padding(innerPadding)
        ){
            composable(BottomNavItem.Home.route) { HomeScreen(rootNavController) }
            composable(BottomNavItem.Shorts.route) { ShortsScreen() }
            composable(BottomNavItem.Live.route) { LiveScreen() }
            composable(BottomNavItem.Search.route) { SearchScreen() }
            composable(BottomNavItem.History.route) { HistoryScreen() }
        }
    }
}