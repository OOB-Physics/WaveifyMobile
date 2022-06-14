package oob.physics.waveify.ui.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val name: String,
    val route: String,
    val icon: ImageVector
) {
    object Home : BottomNavItem(
        name = "Home",
        route = "home",
        icon = Icons.Default.Home
    )
    object Quizziz : BottomNavItem(
        name = "Quizizz",
        route = "quiz",
        icon = Icons.Default.CheckCircle
    )
    object AboutUs : BottomNavItem(
        name = "About Us",
        route = "about_us",
        icon = Icons.Default.AccountCircle
    )

    companion object {
        val items: List<BottomNavItem> = listOf(Home, Quizziz, AboutUs)
    }
}
