package solution

import common.to2DIntArray
import java.util.LinkedList
import java.util.Queue

// https://leetcode.com/problems/01-matrix/
class Sol_542_01_matrix: Solution.General<Array<IntArray>, Array<IntArray>>() {
    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        val queue: Queue<Fill> = LinkedList()
        for(row in mat.indices) {
            for (col in mat[0].indices) {
                if (mat[row][col] == 0) {
                    queue.offer(Fill(row, col, 0))
                }
                mat[row][col] = -1
            }
        }

        while (queue.isNotEmpty()) {
            val nextFill = queue.poll()

            val row = nextFill.row
            val col = nextFill.col
            val fill = nextFill.fill

            if (mat[row][col] == -1) {
                mat[row][col] = fill
                val leftFill = Fill(row, col-1, fill+1)
                val rightFill = Fill(row, col+1, fill+1)
                val topFill = Fill(row-1, col, fill+1)
                val bottomFill = Fill(row+1, col, fill+1)
                if(mat.hasAvailableEmptyCellFor(leftFill)) queue.offer(leftFill)
                if(mat.hasAvailableEmptyCellFor(rightFill)) queue.offer(rightFill)
                if(mat.hasAvailableEmptyCellFor(topFill)) queue.offer(topFill)
                if(mat.hasAvailableEmptyCellFor(bottomFill)) queue.offer(bottomFill)
            }
        }
        return mat
    }

    private fun Array<IntArray>.hasAvailableEmptyCellFor(fill: Fill): Boolean {
        val rowCount = size
        val colCount = if(this.isEmpty()) 0 else this[0].size
        if (fill.row < 0 || fill.row >= rowCount) return false
        if (fill.col < 0 || fill.col >= colCount) return false
        if (this[fill.row][fill.col] != -1) return false
        return true
    }

    private data class Fill(val row: Int, val col: Int, val fill: Int)

    override val givenTestCases: Map<String, Array<IntArray>> = mapOf(
        "[[0,0,0],[0,1,0],[0,0,0]]" to "[[0,0,0],[0,1,0],[0,0,0]]".to2DIntArray(),
        "[[0,0,0],[0,1,0],[1,1,1]]" to "[[0,0,0],[0,1,0],[1,2,1]]".to2DIntArray()
    )
    override val customTestCases: Map<String, Array<IntArray>> = mapOf(
        "[[0,1,0],[0,1,0],[0,1,0],[0,1,0],[0,1,0]]" to  "[[0,1,0],[0,1,0],[0,1,0],[0,1,0],[0,1,0]]".to2DIntArray()
    )

    override fun algorithm(input: Array<IntArray>): Array<IntArray> = updateMatrix(input)
    override fun inputStringToInputType(input: String): Array<IntArray> {
        return input.to2DIntArray()
    }
}