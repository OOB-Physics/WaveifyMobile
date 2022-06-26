package oob.physics.waveify.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import oob.physics.waveify.R
import oob.physics.waveify.ui.nav.BottomNavGraph
import oob.physics.waveify.ui.nav.BottomNavItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    mainNavController: NavController
) {
    val bottomNavController = rememberNavController()

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
                items = BottomNavItem.items,
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
    items: List<BottomNavItem>,
    navController: NavController,
    onItemClick: (BottomNavItem) -> Unit
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