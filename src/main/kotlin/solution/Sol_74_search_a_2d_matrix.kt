package solution

import Solution
import common.to2DIntArray

// https://leetcode.com/problems/search-a-2d-matrix/
class Sol_74_search_a_2d_matrix: Solution.General<Sol_74_search_a_2d_matrix.Params, Boolean>() {
    /**
     * Solution #2
     * Binary Search
     */
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        // y
        var left = 0
        var right = matrix.size - 1
        var y = (left+right)/2

        var found = false
        while (left < right) {
            val compare = matrix[y][0]
            when {
                compare < target -> if (y == matrix.size-1 || matrix[y+1][0] > target) found = true else left = y+1
                compare > target -> right = y-1
                else -> found = true
            }
            if (found) break
            y = (left+right)/2
        }

        // x
        left = 0
        right = matrix[0].size - 1
        var x = (left+right)/2

        found = false
        while (left < right) {
            val compare = matrix[y][x]
            when {
                compare < target -> left = x+1
                compare > target -> right = x-1
                else -> found = true
            }
            if (found) break
            x = (left+right)/2
        }

        return matrix[y][x] == target
    }

    /**
     * Solution #1
     * Linear Search
     */
//    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
//        var x = 0
//        var y = 0
//        while (y < matrix.size-1 && matrix[y+1][0] <= target) y++
//        while (x < matrix[0].size-1 && matrix[y][x] < target) x++
//        return matrix[y][x] == target
//    }

    override val givenTestCases: Map<String, Boolean> = mapOf(
        "[[1,3,5,7],[10,11,16,20],[23,30,34,60]] 3" to true,
        "[[1,3,5,7],[10,11,16,20],[23,30,34,60]] 13" to false
    )
    override val customTestCases: Map<String, Boolean> = mapOf(
        "[[1]] 2" to false,
        "[[1],[3]] 0" to false,
        "[[1],[3]] 3" to true,
        "[[1,3,5,7],[10,11,16,20],[23,30,34,50]] 11" to true
    )

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        val matrix = split[0].to2DIntArray()
        val target = split[1].toInt()
        return Params(matrix, target)
    }
    override fun algorithm(input: Params): Boolean = searchMatrix(input.matrix, input.target)
    class Params(val matrix: Array<IntArray>, val target: Int)
}