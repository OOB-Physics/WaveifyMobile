package oob.physics.waveify.ui

import android.content.Intent
import android.net.Uri
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import oob.physics.waveify.ui.screen.*

/**
 * Main destinations used in the app.
 */
object MainDestinations {
    const val MAIN = "main"
    const val EM_DESCRIPTION = "em_desc"
    const val MAXWELLS_DISCOVERY = "maxwell_discovery"
    const val SPECTRUM = "em_spectrum"
    const val EM_TYPE = "em_type/{id}"
}

/**
 * Navigation destinations used by our BottomNavBar across the app.
 */
object BottomNavDestinations {
    const val HOME = "home"
    const val QUIZ = "quiz"
    const val ABOUT_US = "about_us"
}

@Composable
@OptIn(ExperimentalAnimationApi::class)
fun MainNavGraph() {
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(
        navController = navController,
        startDestination = "main",
        enterTransition = {
            expandHorizontally()
        },
        exitTransition = {
            shrinkHorizontally()
        }
    ) {
        composable(MainDestinations.MAIN) {
            MainScreen(navController)
        }
        composable(MainDestinations.EM_DESCRIPTION) {
            EMDescScreen(navController)
        }
        composable(MainDestinations.MAXWELLS_DISCOVERY) {
            MaxwellsDiscoveryScreen(navController)
        }
        composable(MainDestinations.SPECTRUM) {
            SpectrumScreen(navController)
        }

        composable(
            route = MainDestinations.EM_TYPE,
            arguments = listOf(navArgument("id") { NavType.StringType })
        ) { backStackEntry ->
            EMTypeScreen(
                type = backStackEntry.arguments?.getString("id")!!,
                navController = navController
            )
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun BottomNavGraph(
    bottomNavController: NavHostController,
    mainNavController: NavController,
    startDestination: String = BottomNavDestinations.HOME,
) {
    AnimatedNavHost(
        navController = bottomNavController,
        startDestination = startDestination
    ) {
        composable(route = BottomNavDestinations.HOME) {
            HomeScreen(mainNavController)
        }
        composable(route = BottomNavDestinations.ABOUT_US) {
            AboutUsScreen()
        }

        composable(route = BottomNavDestinations.QUIZ) {
            bottomNavController.navigateUp()
            val context = LocalContext.current
            val webIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://quizizz.com/admin/quiz/62a85ec162c510001e1cc7b6?source=quiz_page")
            )
            context.startActivity(webIntent)
        }
    }
}


enum class BottomNavTabs(
    val title: String,
    val route: String,
    val icon: ImageVector
) {
    Home(title = "Home", route = BottomNavDestinations.HOME, icon = Icons.Default.Home),
    Quiz(title = "Quizizz", route = BottomNavDestinations.QUIZ, icon = Icons.Default.CheckCircle),
    AboutUs(title = "About Us", route = BottomNavDestinations.ABOUT_US, icon = Icons.Default.AccountCircle)
}