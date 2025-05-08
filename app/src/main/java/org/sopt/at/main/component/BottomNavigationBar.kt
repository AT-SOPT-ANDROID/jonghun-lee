package org.sopt.at.main.component

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import kotlinx.collections.immutable.ImmutableList
import org.sopt.at.main.MainTab

@Composable
fun BottomNavigationBar(
    tabs: ImmutableList<MainTab>,
    currentTab: MainTab?,
    onTabSelected: (MainTab) -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier,
        containerColor = Color.Black
    ) {
        tabs.forEach { tab ->
            key(tab.route) {
                val selected = currentTab == tab
                NavigationBarItem(
                    selected = selected,
                    onClick = { onTabSelected(tab) },
                    icon = {
                        Icon(
                            painter = painterResource(id = tab.icon),
                            contentDescription = tab.contentDescription,
                            tint = if (selected) Color.White else Color(0xFF9A9A9A)
                        )
                    },
                    label = {
                        Text(
                            text = tab.contentDescription,
                            color = if (selected) Color.White else Color(0xFF9A9A9A)
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color.Transparent
                    )
                )
            }
        }
    }
}
