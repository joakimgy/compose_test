import androidx.compose.runtime.Composable
import androidx.compose.ui.window.ComposeUIViewController

actual fun getPlatformName(): String = "iOS"

fun MainViewController() = ComposeUIViewController { App() }

@Composable
actual fun MyCustomScreen() {
    ScreenList(onClick = {})
}