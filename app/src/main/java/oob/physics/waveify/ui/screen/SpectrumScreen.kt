package oob.physics.waveify.ui.screen

import android.os.Build
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import oob.physics.waveify.EMType
import oob.physics.waveify.ui.RoundedCard
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
        Image(
            contentDescription = null,
            painter = rememberAsyncImagePainter(
                model = item.resource,
                imageLoader = ImageLoader.Builder(LocalContext.current)
                    .crossfade(true)
                    .components {
                        if (Build.VERSION.SDK_INT >= 28) {
                            add(ImageDecoderDecoder.Factory())
                        } else {
                            add(GifDecoder.Factory())
                        }
                    }
                    .build()
            ),
            modifier = Modifier
                .height(300.dp)
                .fillMaxSize()
                .padding(start = 20.dp, end = 20.dp),
            contentScale = ContentScale.FillBounds
        )

        Spacer(modifier = Modifier.height(50.dp))

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Types of EM Waves",
                style = MaterialTheme.typography.titleLarge,
            )

            Spacer(modifier = Modifier.height(30.dp))

            Row(
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
                    .fillMaxWidth()
            ) {
                EMType.values().forEach {
                    EmTypeItem(navController = navController, emType = it)
                }

                Spacer(modifier = Modifier.width(10.dp))
            }
        }
    }
}

@Composable
fun EmTypeItem(
    navController: NavController,
    emType: EMType
) {
    RoundedCard(
        modifier = Modifier
            .clickable { navController.navigate(emType.route) }
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                model = emType.resourceId,
                imageLoader = ImageLoader.Builder(LocalContext.current)
                    .crossfade(true)
                    .components {
                        if (Build.VERSION.SDK_INT >= 28) {
                            add(ImageDecoderDecoder.Factory())
                        } else {
                            add(GifDecoder.Factory())
                        }
                    }
                    .build()
            ),
            contentDescription = null,
            modifier = Modifier
                .height(150.dp)
                .width(225.dp)
                .fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = emType.title,
            style = MaterialTheme.typography.titleSmall
        )
    }
}