package solution

import common.toIntArray

// https://leetcode.com/problems/house-robber/
class Sol_198_house_robber: Solution.General<IntArray, Int>() {
    fun rob(nums: IntArray): Int {
        return 0
    }

    override val givenTestCases: Map<String, Int> = mapOf(
        "[1,2,3,1]" to 4,
        "[2,7,9,3,1]" to 12
    )

    override fun inputStringToInputType(input: String): IntArray = input.toIntArray()
    override fun algorithm(input: IntArray): Int = rob(input)
}