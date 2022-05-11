package solution

import Solution
import common.to2DIntArray
import java.util.*

private val dirs = listOf(Pair(-1,-1), Pair(-1,0), Pair(-1,1), Pair(0,-1), Pair(0,1), Pair(1,-1), Pair(1,0), Pair(1,1))

class Sol_1091_shortest_path_in_binary_matrix: Solution.General<Array<IntArray>, Int>() {
    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        if (grid[0][0] == 1) return -1
        if (grid[grid.size-1][grid.size-1] == 1) return -1

        grid.convertToShortestPathMatrix()
        val result = grid[grid.size-1][grid.size-1]
        return if (result <= 0) -1 else result
    }

    private fun Array<IntArray>.convertToShortestPathMatrix() {
        val n = this.size

        val queue = LinkedList<Triple<Int, Int, Int>>()
        queue.offer(Triple(0,0, 1))
        while (queue.isNotEmpty()) {
            val cell = queue.poll()
            val i = cell.first
            val j = cell.second
            val currentLength = cell.third
            this[i][j] = currentLength
            if (i == n-1 && j == n-1) return

            dirs.map { Triple(i + it.first, j + it.second, currentLength + 1) }
                .filter { it.first in 0 until n && it.second in 0 until n && this[it.first][it.second] == 0 }
                .forEach {
                    if (this[it.first][it.second] == 0) {
                        this[it.first][it.second] = Integer.MIN_VALUE
                        queue.offer(it)
                    }
                }
        }
    }

    override val givenTestCases: Map<String, Int> = mapOf(
        "[[0,0,0],[1,1,0],[1,1,0]]" to 4,
        "[[0,1],[1,0]]" to 2,
        "[[1,0,0],[1,1,0],[1,1,0]]" to -1
    )
    override val customTestCases: Map<String, Int> = mapOf(
        "[[0,0,1,0,1,1],[1,0,0,1,0,0],[0,1,0,1,0,0],[1,0,1,0,0,0],[0,1,0,1,0,0],[0,0,0,0,0,0]]" to 6,
        "[[0,1,0,0,0,0],[0,1,0,1,1,0],[0,1,1,0,1,0],[0,0,0,0,1,0],[1,1,1,1,1,0],[1,1,1,1,1,0]]" to 14
    )
    override fun inputStringToInputType(input: String): Array<IntArray> = input.to2DIntArray()
    override fun algorithm(input: Array<IntArray>): Int = shortestPathBinaryMatrix(input)
}