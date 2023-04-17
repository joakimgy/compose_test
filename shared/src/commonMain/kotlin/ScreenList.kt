import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ScreenList(onClick: (index: Int) -> Unit) {

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Android",
            modifier = Modifier.padding(16.dp)
        )
        Row {
            Button(onClick = { onClick(1) }, modifier = Modifier.weight(1f).padding(10.dp)) {
                Text(
                    text = "Puzzle", modifier = Modifier.padding(16.dp),
                )
            }
            Button(onClick = { onClick(2) }, modifier = Modifier.weight(1f).padding(10.dp)) {
                Text(text = "Settings", modifier = Modifier.padding(16.dp))
            }
        }
    }
}