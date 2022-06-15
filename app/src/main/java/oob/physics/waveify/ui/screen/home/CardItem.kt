package oob.physics.waveify.ui.screen.home

import oob.physics.waveify.R

sealed class CardItem(
    val title: String,
    val resource: Int,
    val route: String
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

    companion object {
        val items = listOf(EMDesc, MaxWellDiscovery)
    }
}