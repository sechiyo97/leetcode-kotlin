package solution

import Solution
import common.toIntArray

// https://leetcode.com/problems/container-with-most-water/
class Sol_11_container_with_most_water: Solution.General<IntArray, Int>() {
    fun maxArea(height: IntArray): Int {
        return 1
    }

    override val givenTestCases: Map<String, Int> = mapOf(
        "[1,8,6,2,5,4,8,3,7]" to 49,
        "[1,1]" to 1
    )

    override fun inputStringToInputType(input: String): IntArray = input.toIntArray()
    override fun algorithm(input: IntArray): Int  = maxArea(input)
}