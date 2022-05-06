package solution

import Solution
import common.toIntArray

// https://leetcode.com/problems/3sum/
class Sol_15_3sum: Solution.General<IntArray, List<List<Int>>>() {
    fun threeSum(nums: IntArray): List<List<Int>> {
        return listOf(listOf())
    }

    override val givenTestCases: Map<String, List<List<Int>>> = mapOf(
        "[-1,0,1,2,-1,-4]" to listOf(listOf(-1,-1,-2), listOf(-1,0,1)),
        "[]" to listOf(listOf()),
        "[0]" to listOf(listOf())
    )

    override fun inputStringToInputType(input: String): IntArray = input.toIntArray()
    override fun algorithm(input: IntArray): List<List<Int>> = threeSum(input)
}