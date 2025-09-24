package com.hathway.kmm_basic_app.android.ui.login

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LoginScreen(onRegisterClick: () -> Unit) {
    Surface(
        color = MaterialTheme.colorScheme.background, modifier = Modifier.fillMaxSize()
    ) {
        Login(onRegisterClick)

    }
}

@Composable
fun Login(onRegisterClick: () -> Unit) {

}
