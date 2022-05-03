package solution

import Solution
import common.to2DIntArray

// https://leetcode.com/problems/search-a-2d-matrix/
class Sol_74_search_a_2d_matrix: Solution.General<Sol_74_search_a_2d_matrix.Params, Boolean>() {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        return false
    }


    override val givenTestCases: Map<String, Boolean> = mapOf(
        "[[1,3,5,7],[10,11,16,20],[23,30,34,60]] 3" to true,
        "[[1,3,5,7],[10,11,16,20],[23,30,34,60]] 13" to false
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