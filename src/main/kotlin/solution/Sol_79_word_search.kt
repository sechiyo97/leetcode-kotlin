package solution

import Solution
import common.to2DCharArray

class Sol_79_word_search: Solution.General<Sol_79_word_search.Params, Boolean>() {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val height = board.size
        val width = board[0].size
        val checker = Array(height) { Array(width) { BooleanArray(16) } } // 15th is for checking if cell is used
        for (i in 0 until height) {
            for (j in 0 until width) {
                if (tryFindWordFrom(board, word, i, j, 0, checker)) return true
            }
        }
        return false
    }

    private fun tryFindWordFrom(
        board: Array<CharArray>,
        word: String,
        i: Int,
        j: Int,
        idx: Int,
        checker: Array<Array<BooleanArray>>
    ): Boolean {
        if (board[i][j] != word[idx]) {
            checker[i][j][idx] = true
            return false
        }
        if (checker[i][j][idx] || checker[i][j][15]) return false
        if (idx == word.length-1) return true

        checker[i][j][15] = true
        if (i > 0 && tryFindWordFrom(board, word, i-1, j, idx+1, checker)) return true
        if (j > 0 && tryFindWordFrom(board, word, i, j-1, idx+1, checker)) return true
        if (i < board.size-1 && tryFindWordFrom(board, word, i+1, j, idx+1, checker)) return true
        if (j < board[0].size - 1 && tryFindWordFrom(board, word, i, j+1, idx+1, checker)) return true
        checker[i][j][15] = false

        return false
    }

    override val givenTestCases: Map<String, Boolean> = mapOf(
        "[ABCE,SFCS,ADEE] ABCCED" to true,
        "[ABCE,SFCS,ADEE] SEE" to true,
        "[ABCE,SFCS,ADEE] ABCB" to false
    )
    override val customTestCases: Map<String, Boolean> = mapOf(
        "[AAAAAA,AAAAAA,AAAAAA,AAAAAA,AAAAAA,AAAAAA] AAAAAAAAAAAAAAB" to false
    )
    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        val board = split[0].to2DCharArray()
        val word = split[1]
        return Params(board, word)
    }
    override fun algorithm(input: Params): Boolean = exist(input.board, input.word)

    class Params(val board: Array<CharArray>, val word: String)
}