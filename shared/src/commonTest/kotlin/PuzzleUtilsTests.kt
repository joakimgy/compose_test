import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

const val TEST_PUZZLE_SIZE = 2

class PuzzleUtilsTests {


    @Test
    fun `Generate puzzle should give a puzzle of correct size`() {
        assertEquals(generatePuzzle(TEST_PUZZLE_SIZE).size, 9)
    }

    @Test
    fun `Generate puzzle should contains exactly one empty element`() {
        assertEquals(generatePuzzle(TEST_PUZZLE_SIZE).filter { it.empty }.size, 1)
    }

    @Test
    fun `Generate puzzle should not give a sorted array`() {
        assertNotEquals(generatePuzzle(TEST_PUZZLE_SIZE).filterIndexed { index, square ->
            square.id == index + 1
        }.size, TEST_PUZZLE_SIZE * TEST_PUZZLE_SIZE)
    }

    @Test
    fun `isAdjactedToEmptySquare works on 2x2 grid`() {
        val puzzle = testPuzzle2x2
        assertTrue(puzzle[0].isAdjactedToEmptySquare(puzzle))
        assertFalse(puzzle[1].isAdjactedToEmptySquare(puzzle))
        assertFalse(puzzle[2].isAdjactedToEmptySquare(puzzle))
        assertTrue(puzzle[3].isAdjactedToEmptySquare(puzzle))
    }
}

val testPuzzle2x2 = listOf(
    PuzzleSquare(
        id = 1,
        initialPosition = Position(column = 0, row = 0),
        position = Position(column = 1, row = 0),
        empty = false
    ),
    PuzzleSquare(
        id = 2,
        initialPosition = Position(column = 1, row = 0),
        position = Position(column = 1, row = 1),
        empty = true
    ),
    PuzzleSquare(
        id = 3,
        initialPosition = Position(column = 0, row = 1),
        position = Position(column = 0, row = 0),
        empty = false
    ), PuzzleSquare(
        id = 3,
        initialPosition = Position(column = 1, row = 1),
        position = Position(column = 0, row = 1),
        empty = false
    )
)