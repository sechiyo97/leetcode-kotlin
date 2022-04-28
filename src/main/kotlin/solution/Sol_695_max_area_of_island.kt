package solution

import common.to2DIntArray

class Sol_695_max_area_of_island: Solution.General<Array<IntArray>, Int>() {
    override val givenTestCases: Map<String, Int> = mapOf(
        "[[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0]," +
        "[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0]," +
        "[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0]," +
        "[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]" to 6,
        "[[0,0,0,0,0,0,0,0]]" to 0
    )
    override val customTestCases: Map<String, Int> = mapOf(
        "[[1,1,0,0,0],[1,1,0,0,0],[0,0,0,1,1],[0,0,0,1,1]]" to 4
    )

    override fun algorithm(input: Array<IntArray>): Int {
        val grid = input

        var maxCount = 0
        for(i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == 1) {
                    val count = grid.countAndRemoveIsland(i, j)
                    if (count > maxCount) maxCount = count
                }
            }
        }
        return maxCount
    }

    private fun Array<IntArray>.countAndRemoveIsland(i: Int, j: Int): Int {
        var count = 1 // myself
        this[i][j] = 0 // remove
        if (i < this.lastIndex && this[i+1][j] == 1) {
            count += this.countAndRemoveIsland(i+1, j)
        }
        if (i > 0 && this[i-1][j] == 1) {
            count += this.countAndRemoveIsland(i-1, j)
        }
        if (j < this[0].lastIndex && this[i][j+1] == 1) {
            count += this.countAndRemoveIsland(i, j+1)
        }
        if (j > 0 && this[i][j-1] == 1) {
            count += this.countAndRemoveIsland(i, j-1)
        }
        return count
    }

    override fun inputStringToInputType(input: String): Array<IntArray> {
        return input.to2DIntArray()
    }
}