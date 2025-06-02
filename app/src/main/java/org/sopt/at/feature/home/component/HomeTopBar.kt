package org.sopt.at.feature.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import org.sopt.at.R

@Composable
fun HomeTopBar(modifier: Modifier = Modifier,
               onItemClick: () -> Unit) {
    Row(modifier = modifier
        .fillMaxWidth()
        .padding(vertical = 5.dp, horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically

        ) {
        Image(imageVector = ImageVector.vectorResource(R.drawable.ic_tving_logo),
            contentDescription = "logo",
            modifier = Modifier.width(90.dp)
            )
        Spacer(Modifier.weight(1f))

        Image(imageVector = ImageVector.vectorResource(R.drawable.ic_home_broadcast),
            contentDescription = "broadcast",
            modifier = Modifier.width(30.dp)
        )
        Spacer(Modifier.padding(8.dp))

        Image(painter = painterResource(R.drawable.ic_tving_profile),
            contentDescription = "homeProfile",
            modifier = Modifier
                .width(30.dp)
                .clickable {
                    onItemClick()
                }
            )

    }
}