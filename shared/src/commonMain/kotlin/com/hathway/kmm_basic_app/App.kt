package com.hathway.kmm_basic_app

import androidx.compose.runtime.Composable
import com.hathway.kmm_basic_app.common.theme.SnippetsTheme
import com.hathway.kmm_basic_app.ui.login.LoginScreen

@Composable
fun App() {
    SnippetsTheme {
        LoginScreen(onRegisterClick = {})
    }
}
