package org.sopt.at.feature.shorts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ShortsRoute(modifier: Modifier = Modifier) {
    ShortsScreen(modifier = modifier)

}

@Composable
private fun ShortsScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "shorts Screen",
            color = Color.White
        )
    }
}