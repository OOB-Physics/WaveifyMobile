package oob.physics.waveify.ui.screen

import android.os.Build
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import oob.physics.waveify.ui.WideRoundedCard

@Composable
fun EMDescScreen(
    navController: NavController
) {
    val item = CardItem.EMDesc
    NavigableTopAppBar(
        title = item.title,
        navController = navController
    ) {
        var expanded by remember { mutableStateOf(false) }
        val items = listOf(
            DescItem.Definition,
            DescItem.SourcesOfEMWaves,
            DescItem.ReasonsWhyOsc,
            DescItem.HertzExperiment,
            DescItem.MediumRequirements
        )

        var selectedIndex by remember { mutableStateOf(0) }
        var textfieldSize by remember { mutableStateOf(Size.Zero) }

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
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            contentScale = ContentScale.FillWidth
        )

        Box(modifier = Modifier.padding(20.dp)) {
            OutlinedTextField(
                readOnly = true,
                value = items[selectedIndex].title,
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .onGloballyPositioned { coordinates ->
                        //This value is used to assign to the DropDown the same width
                        textfieldSize = coordinates.size.toSize()
                    },
                label = { Text("Topics") },
                trailingIcon = {
                    Icon(Icons.Default.ArrowDropDown, "contentDescription",
                        Modifier.clickable { expanded = !expanded })
                }
            )

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .width(with(LocalDensity.current) { textfieldSize.width.toDp() })
            ) {
                items.forEachIndexed { index, s ->
                    DropdownMenuItem(
                        text = { Text(s.title) },
                        onClick = {
                            selectedIndex = index
                            expanded = false
                        }
                    )
                }
            }
        }

        WideRoundedCard {
            Text(
                text = items[selectedIndex].description,
                style = MaterialTheme.typography.bodyLarge,
            )
        }
    }
}

sealed class DescItem(
    val title: String,
    val description: String
) {
    object Definition : DescItem(
        title = "Definition",
        description = "Electromagnetic waves are disturbances carrying energy that consist of varying electric and magnetic fields perpendicular to each other and also to the propagation vector."
    )

    object SourcesOfEMWaves : DescItem(
        title = "Sources of EM Waves",
        description = "Neither stationary charges nor charges in uniform motion (steady currents) can be sources of electromagnetic waves. The former produces only electrostatic fields, while the latter produces magnetic fields that, however, do not vary with time. It is an important result of Maxwell’s theory that accelerated charges radiate electromagnetic waves."
    )

    object ReasonsWhyOsc : DescItem(
        title = "Reason why oscillating charges produce EM waves?",
        description = "Consider a charge oscillating with some frequency. (An oscillating charge is an example of accelerating charge.) This produces an oscillating electric field in space, which produces an oscillating magnetic field, which in turn, is a source of oscillating electric field, and so on. The oscillating electric and magnetic fields thus regenerate each other, so to speak, as the wave propagates through the space. The frequency of the electromagnetic wave naturally equals the frequency of oscillation of the charge. The energy associated with the propagating wave comes at the expense of the energy of the source – the accelerated charge."
    )


    object HertzExperiment : DescItem(
        title = "Hertz Experiment",
        description = "Hertz was successfully able to produce EM waves through oscillating charges. He was able to produce EM waves in the lower frequency region by using oscillating charges whose natural frequency matches the frequency of the wave. In this way, he was able to prove the existence of the EM waves and its nature.\n" +
                "\n" +
                "\n" +
                "Hertz not only showed the existence of electromagnetic waves, but also demonstrated that the waves, which had wavelength ten million times that of the light waves, could be diffracted, refracted and polarised. Thus, he conclusively established the wave nature of the radiation."
    )

    object MediumRequirements : DescItem(
        title = "Do they require a medium?",
        description = "EM waves do not require a medium to travel because its formed by mutually perpendicular oscillating magnetic and electric fields and not by the motion of any particles. Hence, they can travel in vaccum. \n" +
                "\n" +
                "When EM waves do travel through a medium its speed reduces by a factor of n(refractive index of the medium)."
    )
}