package solution

import Solution
import common.to2DCharArray

class Sol_200_number_of_islands: Solution.General<Array<CharArray>, Int>() {
    fun numIslands(grid: Array<CharArray>): Int {
        if (grid.isEmpty() || grid[0].isEmpty()) return 0
        var count = 0
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == '1') {
                    count++
                    grid.removeIsland(i, j)
                }
            }
        }
        return count
    }

    private fun Array<CharArray>.removeIsland(i: Int, j: Int) {
        this[i][j] = '0'
        if (i > 0 && this[i-1][j] == '1') this.removeIsland(i-1, j)
        if (i < size-1 && this[i+1][j] == '1') this.removeIsland(i+1, j)
        if (j > 0 && this[i][j-1] == '1') this.removeIsland(i, j-1)
        if (j < this[0].size-1 && this[i][j+1] == '1') this.removeIsland(i, j+1)
    }

    override val givenTestCases: Map<String, Int> = mapOf(
        "[11110,11010,11000,00000]" to 1,
        "[11000,11000,00100,00011]" to 3
    )

    override fun inputStringToInputType(input: String): Array<CharArray> = input.to2DCharArray()
    override fun algorithm(input: Array<CharArray>): Int = numIslands(input)
}