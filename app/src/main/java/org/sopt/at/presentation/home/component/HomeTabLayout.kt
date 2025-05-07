package org.sopt.at.presentation.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.at.component.noRippleClickable
import org.sopt.at.presentation.home.model.TabItem
import org.sopt.at.presentation.home.model.TabItem.Companion.visibleTabs

@Composable
fun HomeTabLayout(
    modifier: Modifier,
    selectedTab: TabItem,
    onTabSelected: (TabItem) -> Unit,
) {
    val tabs = visibleTabs

    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 15.dp),
        contentPadding = PaddingValues(horizontal = 5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        items(tabs) { tab ->
            key(tab.name) {
                val isSelected = tab == selectedTab
                Text(
                    text = tab.title,
                    modifier = Modifier.noRippleClickable { onTabSelected(tab) },
                    color = if (isSelected) Color.White else Color.DarkGray,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                    fontSize = 16.sp
                )
            }
        }
    }
}
