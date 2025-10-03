package com.hathway.kmm_basic_app.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hathway.kmm_basic_app.cal.showToast


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingView()
        }

    }
}

@Preview
@Composable
fun GreetingView() {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier
            .padding(8.dp)

    ) {
        Button(onClick = { showToast("Hello from Android!") }) {
            Text("Click Me")
        }
    }
}

