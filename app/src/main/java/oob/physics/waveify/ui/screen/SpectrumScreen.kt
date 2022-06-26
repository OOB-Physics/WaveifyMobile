package oob.physics.waveify.ui.screen

import android.os.Build
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import androidx.navigation.NavController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.google.accompanist.pager.*
import oob.physics.waveify.EMType
import oob.physics.waveify.ui.RoundedCard
import oob.physics.waveify.ui.screen.home.CardItem
import kotlin.math.absoluteValue

@OptIn(ExperimentalPagerApi::class)
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
                .height(250.dp)
                .fillMaxSize()
                .padding(start = 20.dp, end = 20.dp),
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Types of EM Waves",
                style = MaterialTheme.typography.titleLarge,
            )

            Spacer(modifier = Modifier.height(20.dp))

            val pagerState = rememberPagerState()
            val items = EMType.values()
            var selectedItem by remember { mutableStateOf(items[0]) }

            LaunchedEffect(pagerState) {
                snapshotFlow { pagerState.currentPage }.collect { page ->
                    selectedItem = items[page]
                }
            }

            Column(modifier = Modifier.padding(16.dp)) {
                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Wave #${items.indexOf(selectedItem) + 1}",
                    style = MaterialTheme.typography.labelSmall
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = selectedItem.title,
                    style = MaterialTheme.typography.titleMedium
                )
            }

            HorizontalPager(count = items.size, state = pagerState) { page ->
                Image(
                    painter = rememberAsyncImagePainter(
                        model = items[page].resourceId,
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
                        .height(325.dp)
                        .width(350.dp)
                        .graphicsLayer {
                            val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue

                            lerp(
                                start = 0.85f,
                                stop = 1f,
                                fraction = 1f - pageOffset.coerceIn(0f, 1f)
                            ).also { scale ->
                                scaleX = scale
                                scaleY = scale
                            }

                            alpha = lerp(
                                start = 0.5f,
                                stop = 1f,
                                fraction = 1f - pageOffset.coerceIn(0f, 1f)
                            )
                        }.clickable { navController.navigate(items[page].route) },
                    contentScale = item.contentScale
                )

            }

            HorizontalPagerIndicator(
                pagerState = pagerState,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp),
                activeColor = MaterialTheme.colorScheme.secondary
            )
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