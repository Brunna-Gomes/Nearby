package com.rocketseat.nlw.nearby.ui.theme.component.welcome

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.rocketseat.nlw.nearby.ui.theme.theme.Gray500
import com.rocketseat.nlw.nearby.ui.theme.theme.RedBase
import com.rocketseat.nlw.nearby.ui.theme.theme.Typography

@Composable
fun WelcomeHowItWorksTip(
    modifier: Modifier = Modifier,
    subtitle: String,
    title: String,
    @DrawableRes iconRes: Int
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Icon(
            modifier = Modifier.size(32.dp),
            painter = painterResource(id = iconRes),
            tint = RedBase,
            contentDescription = "Ícone Como Funciona"
        )
        Spacer(modifier = Modifier.height(8.dp))
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            Text(text = title, style = Typography.headlineSmall)
            Text(text = subtitle, color = Gray500, style = Typography.bodyLarge)
        }
    }
}