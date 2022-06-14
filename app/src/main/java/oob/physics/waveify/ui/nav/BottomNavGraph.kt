package oob.physics.waveify.ui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import oob.physics.waveify.ui.screen.home.HomeScreen

@Composable
fun BottomNavGraph(
    bottomNavController: NavHostController,
    mainNavController: NavController
) {
    NavHost(
        navController = bottomNavController,
        startDestination = BottomNavItem.Home.route
    ) {
        composable(route = BottomNavItem.Home.route) {
            HomeScreen(mainNavController)
        }
        composable(route = BottomNavItem.AboutUs.route) {

        }

        composable(route = BottomNavItem.Quizziz.route) {

        }
    }
}