package cal.navigation

import HistoryScreen
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cal.screen.CalculatorScreen
import cal.screen.ConversionScreen

@Composable
fun AppWithBottomNav() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            NavigationBar {
                val currentRoute = navController.currentBackStackEntryFlow.collectAsState(initial = null).value?.destination?.route

                BottomNavItem.items.forEach { item ->
                    NavigationBarItem(
                        selected = currentRoute == item.route,
                        onClick = {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.startDestinationId) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { Icon(item.icon, contentDescription = item.label) },
                        label = { Text(item.label) }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomNavItem.Calculator.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(BottomNavItem.Calculator.route) { CalculatorScreen(
                onOpenHistory = { navController.navigate("history") })
             }
            composable(BottomNavItem.History.route) { HistoryScreen(onBack = { navController.popBackStack() }) }
            composable(BottomNavItem.Settings.route) { ConversionScreen() }
        }
    }
}
