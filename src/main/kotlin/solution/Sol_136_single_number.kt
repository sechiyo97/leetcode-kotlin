package solution

import Solution
import common.toIntArray

// https://leetcode.com/problems/single-number/
class Sol_136_single_number: Solution.General<IntArray, Int>() {
    fun singleNumber(nums: IntArray): Int {
        var result = 0
        nums.forEach {
            result = result xor it
        }
        return result
    }

    override val givenTestCases: Map<String, Int> = mapOf(
        "[2.2.1]" to 1,
        "[4,1,2,1,2]" to 4,
        "[1]" to 1
    )

    override fun inputStringToInputType(input: String): IntArray = input.toIntArray()
    override fun algorithm(input: IntArray): Int = singleNumber(input)
}