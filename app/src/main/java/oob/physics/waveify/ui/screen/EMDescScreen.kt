package oob.physics.waveify.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import oob.physics.waveify.ui.screen.home.CardItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EMDescScreen(
    navController: NavController
) {
    val item = CardItem.EMDesc
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = { Text(text = item.title) },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = null)
                    }
                }
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .padding(it)
            ) {

            }
        }
    )

}