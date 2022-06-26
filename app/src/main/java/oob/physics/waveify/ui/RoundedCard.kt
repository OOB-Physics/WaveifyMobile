package oob.physics.waveify.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoundedCard(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(top = 40.dp, start = 16.dp, end = 16.dp, bottom = 8.dp)
    ) {
        Column(
            modifier = modifier
                .padding(start = 20.dp, end = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            content()
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun WideRoundedCard(
    content: @Composable () -> Unit,
) {
    RoundedCard(modifier = Modifier.fillMaxWidth(), content = content)
}