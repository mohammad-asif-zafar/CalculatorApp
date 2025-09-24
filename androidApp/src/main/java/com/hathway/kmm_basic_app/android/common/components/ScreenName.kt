package com.hathway.kmm_basic_app.android.common.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.hathway.kmm_basic_app.android.common.theme.Black
import com.hathway.kmm_basic_app.android.common.theme.Dimens
import com.hathway.kmm_basic_app.android.common.theme.Dimens.paddingStart

@Composable
fun ScreenName( title: String) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(paddingStart),

        contentAlignment = Alignment.CenterStart
    ) {

        Row(modifier = Modifier.padding(start = paddingStart)) {
            Text(
                text = title,
                modifier = Modifier,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold, color = Black
                ),
                fontSize = Dimens.TitleScreenFontSize
            )
        }
    }
}