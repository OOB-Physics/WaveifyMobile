package oob.physics.waveify.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import oob.physics.waveify.R
import oob.physics.waveify.ui.screen.home.CardItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacteristicsScreen(
    navController: NavController
) {
    val item = CardItem.MaxWellDiscovery
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
                    .verticalScroll(rememberScrollState())
            ) {
                RoundedCard {
                    Text(
                        text = "According to Ampere’s circuital law, the magnetic field B is related to " +
                                "steady current i as",
                        style = MaterialTheme.typography.bodyLarge
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Image(
                        painter = painterResource(id = R.drawable.formula1),
                        contentDescription = null
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "where i denotes the current threading the surface bounded by closed path C.",
                        style = MaterialTheme.typography.bodySmall
                    )
                }


                RoundedCard {
                    Text(
                        text = "Maxwell in 1864, showed that the above relation is logically" +
                                "inconsistent. He accounted this inconsistency as follows : ",
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "Consider a parallel plate capacitor having plates P and Q being charged with battery B, During the time, charging is taking place, a current i flows through the connecting wires which changes time. This current will produce magnetic field around the wires which can be detected using a magnetic compass needle. Consider two loops C1 and C2 parallel to the plates P and Q of the capacitor. C1 is enclosing only the connecting wire attached to the plate P of the capacitor and C2 lies in the region between two plates of capacitor.",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "Since the loop C1 has a current i flowing across it, hence Ampere circuital law for loop C1 gives:",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Image(
                        painter = painterResource(id = R.drawable.formula2),
                        contentDescription = null
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "Since the loop C2 lies in the region between the plates of the capacitor, no current flows in this region. Hence Ampere’s circuital law for loop C2 gives:",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Image(
                        painter = painterResource(id = R.drawable.formula3),
                        contentDescription = null
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "But on using a compass it is seen that the compass shows deflection, indicating the presence of a magnetic field. This is a contradiction to the above result of the Ampere’s Equation.",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "To solve this inconsistency, Maxwell introduced a term called “displacement current”.\nThis current is observed in a region where the electric field and hence the electric flux is changing with time.",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Image(
                        painter = painterResource(id = R.drawable.formula4),
                        contentDescription = null
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "He also introduced the term conduction current to denote the\n" +
                                "conventional current:\n" +
                                "\n" +
                                "'The current that is observed due to the flow of charges and electrons'\n" +
                                "\n" +
                                "Including both conduction current and displacement current in Ampere’s Circuital Law we get:",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Image(
                        painter = painterResource(id = R.drawable.formula5),
                        contentDescription = null
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "This is the generalized form of Ampere’s circuital law as modified by Maxwell and is known as Ampere-Maxwell Law.",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                RoundedCard {
                    Text(
                        text = "Continuity of current:",
                        style = MaterialTheme.typography.titleLarge
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "“The sum of magnitudes of conduction current and displacement " +
                                "current remains constant.”\n" +
                                "\n" +
                                "In the above Maxwell’s experiment:\n" +
                                "\n" +
                                "The value of conduction current in the wires is maximum but " +
                                "zero inside the capacitor, whereas the value of displacement current is zero outside the " +
                                "capacitor and attains maximum value between the capacitor " +
                                "plates. \n\nHence, from the above example the continuity of current is explained",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                RoundedCard {
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        Image(
                            painter = painterResource(id = R.drawable.formula6),
                            contentDescription = null
                        )
                    }
                }
            }
        }
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoundedCard(
    content: @Composable () -> Unit
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(top = 40.dp, start = 16.dp, end = 16.dp, bottom = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
                .fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            content()
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}