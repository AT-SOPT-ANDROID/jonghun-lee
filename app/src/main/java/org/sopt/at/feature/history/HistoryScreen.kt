package org.sopt.at.feature.history

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
fun HistoryRoute(modifier: Modifier = Modifier) {
    HistoryScreen(modifier = modifier)
}

@Composable
fun HistoryScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "history Screen",
            color = Color.White
        )
    }
}