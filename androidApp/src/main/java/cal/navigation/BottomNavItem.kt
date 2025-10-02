package cal.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val route: String, val label: String, val icon: ImageVector) {
    object Calculator : BottomNavItem("calculator", "Calc", Icons.Default.Calculate)
    object History : BottomNavItem("history", "History", Icons.Default.History)
    object Settings : BottomNavItem("settings", "Settings", Icons.Default.Settings)

    companion object {
        val items = listOf(Calculator, History, Settings)
    }
}