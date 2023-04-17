import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun SettingsScreen(onClick: () -> Unit) {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Settings screen",
            modifier = Modifier.padding(16.dp)
        )
        Button(onClick = { onClick() }, modifier = Modifier.padding(10.dp)) {
            Text(
                text = "Go back", modifier = Modifier.padding(16.dp),
            )
        }
    }
}