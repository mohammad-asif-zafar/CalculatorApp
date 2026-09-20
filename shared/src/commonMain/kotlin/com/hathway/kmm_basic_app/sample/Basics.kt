package com.hathway.kmm_basic_app.sample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun BasicColumn() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center).background(Color.Yellow)
        ) {
            Text("Item 1")
            Text("Item 2")
            Text("Item 1")
            Text("Item 2")
            Text("Item 1")
            Text("Item 2")
            Text("Item 2")
            Text("Item 2")
            Text("Item 2")
            Text("Item 1")
            Text("Item 2")
            Text("Item 2")
            Text("Item 2")
            Text("Item 2")
            Text("Item 1")
            Text("Item 2")
            Text("Item 2")
            Text("Item 2")
        }
    }
}
