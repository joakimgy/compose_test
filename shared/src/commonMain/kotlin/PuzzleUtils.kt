fun moveSquareAndReturnUpdatedPuzzle(
    puzzle: List<PuzzleSquare>,
    squarePressed: PuzzleSquare
): List<PuzzleSquare> {

    return if (squarePressed.isAdjactedToEmptySquare(puzzle)) {
        puzzle.swap(
            puzzle.indexOfFirst { it.empty },
            puzzle.indexOfFirst { it.id == squarePressed.id }
        )
    } else {
        puzzle
    }
}

fun <T> List<T>.swap(index1: Int, index2: Int): List<T> {
    val mutableList = this.toMutableList()
    val tmp = mutableList[index1]
    mutableList[index1] = this[index2]
    mutableList[index2] = tmp
    return mutableList.toList()
}

private fun List<PuzzleSquare>.getEmptySquare(): PuzzleSquare =
    this.find { it.empty } ?: throw Error("No empty square found")

fun PuzzleSquare.isAdjactedToEmptySquare(puzzle: List<PuzzleSquare>): Boolean {
    if (this.empty) return false
    val emptySquare = puzzle.getEmptySquare()
    if (this.position.column == emptySquare.position.column - 1 && this.position.row == emptySquare.position.row) {
        return true
    } else if (this.position.column == emptySquare.position.column + 1 && this.position.row == emptySquare.position.row) {
        return true
    } else if (this.position.column == emptySquare.position.column && this.position.row + 1 == emptySquare.position.row) {
        return true
    } else if (this.position.column == emptySquare.position.column && this.position.row - 1 == emptySquare.position.row) {
        return true
    }
    return false
}

fun generatePuzzle(size: Int) =
    (1..size * size).shuffled().mapIndexed { index, n ->
        PuzzleSquare(
            id = index,
            position = Position(
                column = n % size,
                row = n / size
            ),
            initialPosition = Position(
                column = index % size,
                row = index / size
            )
        )
    }
        .toMutableList()
        .apply { this.last().empty = true }
        .toList()

