package com.hathway.kmm_basic_app.android

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cal.navigation.CalculatorAppRoot
import cal.viewmodel.ItemsViewModel


class MainActivity : ComponentActivity() {
    private val viewModel: ItemsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorAppRoot()
        }
        viewModel._UiEvent.observe(this) { value ->
            Log.d("ItemsActivity", "Count updated: $value")
            // update UI here (TextView, etc.)
        }
    }
}

@Preview
@Composable
fun GreetingView() {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)

    ) {

    }
}

