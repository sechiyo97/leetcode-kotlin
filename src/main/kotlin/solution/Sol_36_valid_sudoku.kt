package solution

import Solution
import common.to2DCharArray
import common.to2DStringArray

// https://leetcode.com/problems/valid-sudoku/
class Sol_36_valid_sudoku: Solution.General<Sol_36_valid_sudoku.Params, Boolean>() {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        return checkLinesValid(board) && checkBoxes(board)
    }

    private fun checkLinesValid(board: Array<CharArray>): Boolean {
        for (i in 0 until 9) {
            val horizontalCheckArray = BooleanArray(10) { false }
            val verticalCheckArray = BooleanArray(10) { false }
            for (j in 0 until 9) {
                val horizontalNum = board[i][j].toString().toIntOrNull()
                if (horizontalNum != null) {
                    if (horizontalCheckArray[horizontalNum]) return false
                    horizontalCheckArray[horizontalNum] = true
                }

                val verticalNum = board[j][i].toString().toIntOrNull()
                if (verticalNum != null) {
                    if (verticalCheckArray[verticalNum]) return false
                    verticalCheckArray[verticalNum] = true
                }
            }
        }
        return true
    }

    private fun checkBoxes(board: Array<CharArray>): Boolean {
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                val iStart = i*3
                val jStart = j*3
                val boxCheckArray = BooleanArray(10) { false }
                for (iAdd in 0 until 3) {
                    for (jAdd in 0 until 3) {
                        val boxNum = board[iStart+iAdd][jStart+jAdd].toString().toIntOrNull()
                        if (boxNum != null) {
                            if (boxCheckArray[boxNum]) return false
                            boxCheckArray[boxNum] = true
                        }
                    }
                }
            }
        }
        return true
    }

    override val givenTestCases: Map<String, Boolean> = mapOf(
        "[[\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"]\n" +
                ",[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"]\n" +
                ",[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"]\n" +
                ",[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"]\n" +
                ",[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"]\n" +
                ",[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"]\n" +
                ",[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"]\n" +
                ",[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"]\n" +
                ",[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]" to true,
        "[[\"8\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"]\n" +
                ",[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"]\n" +
                ",[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"]\n" +
                ",[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"]\n" +
                ",[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"]\n" +
                ",[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"]\n" +
                ",[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"]\n" +
                ",[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"]\n" +
                ",[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]" to false
    )

    override val customTestCases: Map<String, Boolean> = mapOf(
    )

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        val board = split[0].to2DStringArray().map { it.map { it[0] }.toCharArray() }.toTypedArray()
        return Params(board)
    }
    override fun algorithm(input: Params): Boolean = isValidSudoku(input.board)
    class Params(val board: Array<CharArray>)
}
