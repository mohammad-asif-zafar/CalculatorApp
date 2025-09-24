package com.hathway.kmm_basic_app.android.sample

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hathway.kmm_basic_app.android.R


@Preview
@Composable
fun DefaultPreview() {
    BasicColumnRow()
}


@Composable
fun BasicColumnRow() {
    val names = listOf("Alice", "Bob", "Charlie", "David", "Eve")
    val context = LocalContext.current // 👈 Required for showing Toast

    Surface(
        color = MaterialTheme.colorScheme.background, modifier = Modifier.fillMaxSize()

    ) {
        Box(
            modifier = Modifier
                .size(200.dp)
                .padding(16.dp)
        ) {
            // Background Image
            Image(
                painter = painterResource(R.drawable.img),
                contentDescription = "Avatar",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape) // Optional: make it round
            )

            // Overlay Button
            Button(
                onClick = { Toast.makeText(context, "Hello Minion", Toast.LENGTH_LONG).show() },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(8.dp)
            ) {
                Text("Edit")
            }
        }

    }
}
