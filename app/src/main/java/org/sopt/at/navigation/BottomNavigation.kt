package org.sopt.at.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigation(navController: NavHostController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Shorts,
        BottomNavItem.Live,
        BottomNavItem.Search,
        BottomNavItem.History
    )
    NavigationBar(
        containerColor = Color.Black
    ){
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach{ item ->
            val isSelected = currentRoute == item.route
            NavigationBarItem(
                icon = { Icon(
                    painter = painterResource(id = item.icon),
                    contentDescription = item.title,
                    tint = if (isSelected) Color.White else Color(0xFF9A9A9A))},
                label = { Text(
                    text = item.title,
                    color = if (isSelected) Color.White else Color(0xFF9A9A9A)) },
                selected = isSelected,
                onClick = {
                    navController.navigate(item.route){
                        popUpTo(navController.graph.findStartDestination().id){
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent
                )

            )
        }
    }
}