package oob.physics.waveify

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import oob.physics.waveify.ui.RoundedCard
import oob.physics.waveify.ui.WideRoundedCard

sealed class EMType(
    val resourceId: Int,
    val title: String,
    val route: String,
    val wavelength: String,
    val frequency: String,
    val production: String,
    val uses: String,
    val extraContent: @Composable () -> Unit = {},
) {
    object Microwave : EMType(
        resourceId = R.drawable.anim_micro,
        title = "Microwave",
        route = "microwave",
        wavelength = "1mm – 0.1m",
        frequency = "In the Ghz range",
        uses = "1.\tAircraft Navigation\n" +
                "2.\tSpeed guns: To measure the speed of vehicles or any other fast moving object.\n" +
                "3.\tMicrowave.",
        production = "They are produced from special vacuum tubes called klystrons, magnetrons, gunn diodes.",
        extraContent = {
            WideRoundedCard {
                Text(
                    text = "Microwave : How does it work?",
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Microwaves are used to heat up food items and cook it but how does it actually work?\n" +
                            "The  resonant frequency of water molecules in a food item is roughly 2.45 GHz which lies in the microwave region of the EM spectrum.\n" +
                            "\n" +
                            "In a microwave, EM waves with a frequency matching the natural frequency of water molecules are send through the food items. The water molecules present in the food article absorb this energy and in turn heats up. These molecules share this energy with neighboring food molecules, heating up the food.",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    )

    object UltraViolet : EMType(
        resourceId = R.drawable.anim_uv,
        title = "Ultra Violet",
        route = "ultraviolet",
        wavelength = "400 nm to 1 nm",
        frequency = "10^15 Hz to 10^17 Hz",
        production = "Inner shell electrons in atoms moving form one energy level to a lower level. " +
                "They are also produced by very hot bodies.",
        uses = "1.\tUV lamps are used to kill germs in water purifiers.\n" +
                "2.\tUV radiations are used in high precision applications like LASIK eye surgery due to its shorter wavelengths.\n",
        extraContent = {
            RoundedCard {
                Text(
                    text = "Harmful Effects",
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Sun is an important source of UV radiations. Fortunately, most of the radiations are absorbed by the green house layer\n" +
                            "\n" +
                            "1.\tExposure of excessive UV radiation on human skin leads to tanning, skin cancer and other skin diseases.\n" +
                            "2.\tWelders wear special goggles or face masks with glass windows to protect them from large amount of UV that is produced by welding arcs since UV rays can’t penetrate through glass.",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    )

    object XRay : EMType(
        resourceId = R.drawable.anim_xray,
        title = "X-Ray",
        route = "xray",
        wavelength = "1nm – 400nm",
        frequency = "10^16 Hz to 10^19 Hz",
        production = "They are produced in X ray tubes or by inner shell electrons. " +
                "Another way is to bombard metal atom with high energy electrons.",
        uses = "X rays are widely used in medical applications. They are used as a diagnostic tool in medicine as a treatment for certain forms of cancer.\n" +
                "\n" +
                "But care must be taken whole using X rays because they have the ability to cause severe damage to organs and destroy tissues and organisms."
    )

    object RadioWave : EMType(
        resourceId = R.drawable.anim_radio,
        title = "Radio Waves",
        route = "radiowaves",
        wavelength = ">0.1m",
        frequency = "500kHz to 1000 Mhz",
        production = "They are produced by accelerated charges in conducting wires. " +
                "Rapid acceleration or deceleration of electrons in aerials.",
        uses = "1. They are primarily used in radio wave communication using antenna,etc.\n" +
                "2. Cell phones transmit voice communication in the UHF band(ultra high frequency).\n" +
                "3. TV ranges include 54 MHz to 890 MHz"
    )

    object Infrared : EMType(
        resourceId = R.drawable.anim_infrared,
        title = "Infrared",
        route = "infrared",
        wavelength = "1mm – 700nm",
        frequency = "10^12Hz to 10^14 Hz",
        production = "They are produced from hot bodies and objects due to the vibration of atoms and molecules.",
        uses = "1.\tInfrared lamps are used in physical therapy.\n" +
                "2.\tThe play an important role in maintaining the earths warmth through green house effect.\n" +
                "3.\tElectronic devices emit infrared waves and this principle is primarily used in Bluetooth technology and remotes.\n" +
                "4.\tInfrared detectors are also present in Earths Satellites both for military purposes and to observe growth of crops.",
        extraContent = {
            WideRoundedCard {
                Text(
                    text = "Why are they called heat waves?",
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "They are often referred to as heat waves because water molecules present in most materials readily absorb infrared waves(many other molecules like CO, NH3 also absorb infrared waves).\n" +
                            "\n" +
                            "After absorption, their thermal motion increases that is they heat up and their surroundings.",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    )

    object Visible : EMType(
        resourceId = R.drawable.anim_visible,
        title = "Visible Rays",
        route = "visible",
        wavelength = "700nm - 400nm",
        frequency = "4 x 10^14Hz to 7 x 10^14Hz",
        production = "Electrons in atoms emit light when they move from one energy level to a lower energy level.",
        uses = "The eye, photocells, photographic film\n",
        extraContent = {
            WideRoundedCard {
                Text(
                    text = "Spectrum of Visible Light",
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.height(30.dp))

                Image(
                    painter = painterResource(id = R.drawable.spectrum_of_visible),
                    contentDescription = null
                )
            }
        }
    )


    companion object {
        fun values(): List<EMType> =
            listOf(Microwave, UltraViolet, Infrared, Visible, XRay, RadioWave)
    }
}
