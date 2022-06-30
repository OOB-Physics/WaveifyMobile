package oob.physics.waveify.ui.screen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import oob.physics.waveify.ui.BottomNavGraph
import oob.physics.waveify.ui.BottomNavTabs
import oob.physics.waveify.R

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun MainScreen(
    mainNavController: NavController
) {
    val bottomNavController = rememberAnimatedNavController()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    val painter = painterResource(id = R.drawable.logo_transparent)
                    Image(
                        painter = painter,
                        contentDescription = null,
                        modifier = Modifier
                            .size(50.dp)
                    )
                }
            )
        },
        bottomBar = {
            BottomNavBar(
                navController = bottomNavController,
                onItemClick = {
                    bottomNavController.navigate(it.route)
                }
            )
        },
        content = {
            Surface(
                modifier = Modifier
                    .padding(it)
            ) {
                BottomNavGraph(bottomNavController, mainNavController)
            }
        }
    )

}

@Composable
fun BottomNavBar(
    items: Array<BottomNavTabs> = BottomNavTabs.values(),
    navController: NavController,
    onItemClick: (BottomNavTabs) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()

    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = null) },
                label = { Text(item.name) },
                selected = item.route == backStackEntry.value?.destination?.route,
                onClick = { onItemClick(item) }
            )
        }
    }
}