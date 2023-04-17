import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


@OptIn(ExperimentalResourceApi::class, ExperimentalAnimationApi::class)
@Composable
fun App() {

    MaterialTheme {
        var showImage by remember { mutableStateOf(false) }

        LaunchedEffect(Unit) {
            while (true) {
                showImage = !showImage
                delay(1000)
            }
        }

        Column(
            Modifier.fillMaxWidth().fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(modifier = Modifier.height(70.dp)) {
                AnimatedVisibility(
                    visible = showImage,
                    enter = slideInHorizontally() + scaleIn(),
                    exit = slideOutHorizontally { it } + scaleOut(),

                    ) {
                    Image(
                        painterResource("compose-multiplatform.xml"),
                        null,
                    )
                }
            }
            MyCustomScreen()
        }
    }
}

expect fun getPlatformName(): String

@Composable
expect fun MyCustomScreen(): Unit