import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Position(
    val column: Int,
    val row: Int
)

data class PuzzleSquare(
    val id: Int,
    var position: Position,
    val initialPosition: Position,
    var empty: Boolean = false
)

const val PUZZLE_SIZE = 2

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PuzzleScreen(onClick: (index: Int) -> Unit) {
    val squares = generatePuzzle(PUZZLE_SIZE)

    var puzzle by remember { mutableStateOf(squares) }

    Column(
        modifier = Modifier.padding(16.dp).fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = "Puzzle",
            modifier = Modifier.padding(16.dp),
            fontSize = 30.sp
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(PUZZLE_SIZE),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            println(puzzle.find { it.empty })
            puzzle.map { square ->
                item(
                    span = { GridItemSpan(1) },
                    key = square.id
                ) {
                    Box(
                        modifier = Modifier
                            .background(if (square.empty) Color.Transparent else Color.Cyan)
                            .alpha(if (square.empty) 0f else 1f)
                            .aspectRatio(1f)
                            .animateItemPlacement()
                            .clickable {
                                println("Puzzle")
                                println(puzzle)
                                puzzle = moveSquareAndReturnUpdatedPuzzle(puzzle, square)
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Column {
                            Text("Row ${square.initialPosition.row}")
                            Text("Col ${square.initialPosition.column}")
                        }
                    }
                }
            }
        }

        Button(onClick = { onClick(1) }, modifier = Modifier.padding(10.dp)) {
            Text(
                text = "Go back", modifier = Modifier.padding(16.dp),
            )
        }
    }
}