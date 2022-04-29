package solution

import common.to2DIntArray

class Sol_994_rotting_oranges: Solution.General<Array<IntArray>, Int>() {
    override val givenTestCases: Map<String, Int> = mapOf(
        "[[2,1,1],[1,1,0],[0,1,1]]" to 4,
        "[[2,1,1],[0,1,1],[1,0,1]]" to -1,
        "[[0,2]]" to 0
    )
    override val customTestCases: Map<String, Int> = mapOf(
        "[[0,2,2]]" to 0,
        "[[2,2],[1,1],[0,0],[2,0]]" to 1,
        "[[1,2]]" to 1
    )

    override fun algorithm(input: Array<IntArray>): Int {
        val grid = input

        var left = 0
        val queue = mutableListOf<Pair<Int,Int>>()
        for(row in grid.indices) {
            for (col in grid[0].indices) {
                if (grid[row][col] == 2) {
                    queue.add(Pair(row, col))
                } else if (grid[row][col] == 1) {
                    left++
                }
            }
        }

        var curTime = 0
        while (queue.isNotEmpty()) {
            val queueSize = queue.size
            for (i in 0 until queueSize) {
                val coord = queue.removeAt(0)

                val row = coord.first
                val col = coord.second

                val rowCount = grid.size
                val colCount = if(grid.isEmpty()) 0 else grid[0].size

                if (col-1 >= 0 && grid[row][col-1] == 1) {
                    val nextCoord = Pair(row, col - 1)
                    grid[nextCoord.first][nextCoord.second] = 2
                    queue.add(nextCoord)
                    left--

                }
                if (col+1 < colCount && grid[row][col+1] == 1) {
                    val nextCoord = Pair(row, col + 1)
                    grid[nextCoord.first][nextCoord.second] = 2
                    queue.add(nextCoord)
                    left--
                }
                if (row-1 >= 0 && grid[row-1][col] == 1) {
                    val nextCoord = Pair(row - 1, col)
                    grid[nextCoord.first][nextCoord.second] = 2
                    queue.add(nextCoord)
                    left--
                }
                if (row+1 < rowCount && grid[row+1][col] == 1) {
                    val nextCoord = Pair(row + 1, col)
                    grid[nextCoord.first][nextCoord.second] = 2
                    queue.add(nextCoord)
                    left--
                }
            }
            if (queue.isNotEmpty()) curTime++
        }

        return if (left>0) -1 else curTime
    }

    override fun inputStringToInputType(input: String): Array<IntArray> {
        return input.to2DIntArray()
    }
}