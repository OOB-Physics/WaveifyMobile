package oob.physics.waveify.ui.screen

import android.os.Build
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import oob.physics.waveify.EMType
import oob.physics.waveify.ui.RoundedCard

@Composable
fun EMTypeScreen(
    type: String,
    navController: NavController
) {
    val emType = EMType.values().first { it.title == type }
    NavigableTopAppBar(
        title = emType.title,
        navController = navController
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            RoundedCard {
                Text(
                    text = "V: ${emType.frequency}",
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "λ: ${emType.wavelength}",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }

        Image(
            contentDescription = null,
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
            modifier = Modifier
                .height(300.dp)
                .fillMaxSize()
                .padding(start = 20.dp, end = 20.dp),
            contentScale = ContentScale.FillBounds
        )

        RoundedCard {
            Text(
                text = "Production",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = emType.production,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        RoundedCard {
            Text(
                text = "Uses",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = emType.uses,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        emType.extraContent()
    }
}