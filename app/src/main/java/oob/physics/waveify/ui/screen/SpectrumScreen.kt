package oob.physics.waveify.ui.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import oob.physics.waveify.ui.screen.home.CardItem

@Composable
fun SpectrumScreen(
    navController: NavController
) {
    val item = CardItem.Spectrum
    NavigableTopAppBar(
        title = item.title,
        navController = navController
    ) {

    }
}