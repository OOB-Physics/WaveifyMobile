package oob.physics.waveify.ui.screen.home

import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import androidx.navigation.NavController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.google.accompanist.pager.*
import oob.physics.waveify.R
import kotlin.math.absoluteValue

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen(
    navController: NavController
) {
    val items = CardItem.items
    var selectedItem by remember { mutableStateOf(items[0]) }

    val pagerState = rememberPagerState()
    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            selectedItem = items[page]
        }
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Concept #${items.indexOf(selectedItem) + 1}",
                style = MaterialTheme.typography.labelSmall
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = selectedItem.title,
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(24.dp))
        }

        Spacer(modifier = Modifier.size(12.dp))

        HorizontalPager(count = items.size, state = pagerState) { page ->
            val item = items[page]

            Image(
                painter = rememberAsyncImagePainter(
                    model = item.resource,
                    imageLoader = ImageLoader.Builder(LocalContext.current)
                        .crossfade(true)
                        .components {
                            if (SDK_INT >= 28) {
                                add(ImageDecoderDecoder.Factory())
                            } else {
                                add(GifDecoder.Factory())
                            }
                        }
                        .build()
                ),
                contentDescription = null,
                modifier = Modifier
                    .height(300.dp)
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
                    },
                contentScale = ContentScale.FillHeight
            )

        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp),
            activeColor = MaterialTheme.colorScheme.secondary
        )

        Spacer(modifier = Modifier.size(24.dp))
        Button(
            onClick = {
                navController.navigate(selectedItem.route)
            }
        ) {
            Text(text = stringResource(R.string.learn_more))
        }

    }
}