import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

actual fun getPlatformName(): String = "Android"

@Composable
fun MainView() = App()


@Composable
actual fun MyCustomScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "puzzle") {
        composable("list") {
            ScreenList(onClick = {
                when (it) {
                    1 -> navController.navigate("puzzle")
                    2 -> navController.navigate("settings")
                }
            })
        }
        composable("puzzle") { PuzzleScreen { navController.navigate("list") } }
        composable("settings") { SettingsScreen { navController.navigate("list") } }
    }
}