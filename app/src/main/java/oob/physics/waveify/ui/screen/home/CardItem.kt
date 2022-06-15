package oob.physics.waveify.ui.screen.home

import androidx.compose.ui.layout.ContentScale
import oob.physics.waveify.R

sealed class CardItem(
    val title: String,
    val resource: Int,
    val route: String,
    val contentScale: ContentScale = ContentScale.FillHeight
) {
    object EMDesc : CardItem(
        title = "What are Electromagnetic Waves?",
        resource = R.raw.wave_anim,
        route = "em_desc"
    )

    object MaxWellDiscovery : CardItem(
        title = "MaxWell's Discovery",
        resource = R.drawable.maxwell,
        route = "maxwell_discovery"
    )

    object Spectrum : CardItem(
        title = "The Electromagnetic Spectrum",
        resource = R.drawable.spectrum,
        route = "em_spectrum",
        contentScale = ContentScale.Fit
    )

    companion object {
        val items = listOf(EMDesc, MaxWellDiscovery, Spectrum)
    }
}