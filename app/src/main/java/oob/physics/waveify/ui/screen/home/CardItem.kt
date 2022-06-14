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

    object EMCharacteristics : CardItem(
        title = "Characteristics of EM Waves",
        resource = R.raw.wave_anim,
        route = "em_characteristics"
    )

    companion object {
        val items = listOf(EMDesc, EMCharacteristics)
    }
}