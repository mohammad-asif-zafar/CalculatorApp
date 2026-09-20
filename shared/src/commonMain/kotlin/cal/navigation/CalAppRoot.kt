package cal.navigation

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cal.screen.CalculatorScreen
import cal.screen.HistoryScreen

@Composable
fun CalculatorAppRoot() {

    val navController = rememberNavController()
    MaterialTheme {
        NavHost(navController = navController, startDestination = "calculator") {
            composable("calculator") {
                CalculatorScreen(
                    onOpenHistory = { navController.navigate("history") }
                )
            }
            composable("history") {
                HistoryScreen(onBack = { navController.popBackStack() })
            }
        }
    }
}
