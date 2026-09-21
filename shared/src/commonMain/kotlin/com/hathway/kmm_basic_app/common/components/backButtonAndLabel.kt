package com.hathway.kmm_basic_app.common.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.hathway.kmm_basic_app.common.theme.Dimens.PaddingSmall
import com.hathway.kmm_basic_app.common.theme.Dimens.paddingStart


@Composable
fun BackButtonAndLabel(onBackClick: () -> Unit, title: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(paddingStart), // Typical toolbar height
        contentAlignment = Alignment.Center
    ) {
        // Back Arrow aligned to the start (left)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = PaddingSmall),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack, // Material icon
                    contentDescription = "Back"
                )
            }
        }
        // Title centered in the Box
        Text(
            text = title, style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold, color = Color.Black
            )
        )
    }
}
