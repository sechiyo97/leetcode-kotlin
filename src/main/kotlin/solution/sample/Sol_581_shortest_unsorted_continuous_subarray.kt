package solution.sample

import Solution
import common.toIntArray

// https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
class Sol_581_shortest_unsorted_continuous_subarray: Solution.General<IntArray, Int>() {
    fun findUnsortedSubarray(nums: IntArray): Int {
        return 0
    }

    override val givenTestCases: Map<String, Int> = mapOf(
        "[2,6,4,8,10,9,15]" to 5,
        "[1,2,3,4]" to 0,
        "[1]" to 0
    )

    override fun inputStringToInputType(input: String): IntArray = input.toIntArray()
    override fun algorithm(input: IntArray): Int = findUnsortedSubarray(input)
}