package oob.physics.waveify.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import oob.physics.waveify.ui.theme.WaveifyMobileTheme

@Composable
fun WaveifyApp() {
    WaveifyMobileTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MainNavGraph()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WaveifyApp()
}