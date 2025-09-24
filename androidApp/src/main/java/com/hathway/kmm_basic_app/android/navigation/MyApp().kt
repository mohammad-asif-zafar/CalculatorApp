package com.hathway.kmm_basic_app.android.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hathway.kmm_basic_app.android.ui.login.LoginScreen
import com.hathway.kmm_basic_app.android.ui.register.RegistrationScreen

@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController, startDestination = "login"
    ) {
        composable("login") {
            LoginScreen(
                onRegisterClick = { navController.navigate("register") })
        }
        composable("register") {
            RegistrationScreen(
                onLoginClick = { navController.navigate("login") })
        }
    }
}
