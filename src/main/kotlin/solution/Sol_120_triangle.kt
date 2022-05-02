package solution

import Solution
import common.to2DIntArray

// https://leetcode.com/problems/triangle/
class Sol_120_triangle: Solution.General<List<List<Int>>, Int>() {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        if (triangle.size == 1) return triangle[0][0]

        val result = Array(triangle.size) { IntArray(it+1) }
        result[triangle.size - 1] = triangle[triangle.size - 1].toIntArray()

        for (i in 1 until triangle.size) {
            val depth = triangle.size - i - 1
            for (j in triangle[depth].indices) {
                val minSubTree1 = result[depth+1][j]
                val minSubTree2 = result[depth+1][j+1]
                result[depth][j] = triangle[depth][j] + if (minSubTree1 < minSubTree2) minSubTree1 else minSubTree2
            }
        }

        return result[0][0]
    }

    override val givenTestCases: Map<String, Int> = mapOf(
        "[[2],[3,4],[6,5,7],[4,1,8,3]]" to 11,
        "[[-10]]" to -10
    )

    override fun inputStringToInputType(input: String): List<List<Int>> = input.to2DIntArray().toList().map { it.toList() }
    override fun algorithm(input: List<List<Int>>): Int = minimumTotal(input)
}