package oob.physics.waveify.ui.nav

import android.content.Intent
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
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
            bottomNavController.navigateUp()
            val context = LocalContext.current
            val webIntent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://quizizz.com/admin/quiz/62a85ec162c510001e1cc7b6?source=quiz_page"))
            context.startActivity(webIntent)
        }
    }
}