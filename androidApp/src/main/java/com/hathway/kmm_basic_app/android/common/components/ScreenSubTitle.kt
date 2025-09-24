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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.hathway.kmm_basic_app.android.common.theme.Dimens
import com.hathway.kmm_basic_app.android.common.theme.Dimens.subTitleDimen
import com.hathway.kmm_basic_app.android.common.theme.Grey

@Composable
fun ScreenSubTitle(title: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),

        contentAlignment = Alignment.CenterStart
    ) {

        Row(modifier = Modifier.padding(start = 50.dp)) {
            Text(
                text = title,
                modifier = Modifier,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold, color = Grey
                ),
                fontSize = Dimens.FontLarge
            )
        }
    }
}