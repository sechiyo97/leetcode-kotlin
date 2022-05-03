package solution.sample

import Solution
import common.toIntArray

// https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
class Sol_581_shortest_unsorted_continuous_subarray: Solution.General<IntArray, Int>() {
    fun findUnsortedSubarray(nums: IntArray): Int {
        val size = nums.size
        val maxArray = IntArray(nums.size)
        val minArray = IntArray(nums.size)

        maxArray[0] = nums[0]
        minArray[size-1] = nums[size-1]
        for (i in 1 until size) {
            maxArray[i] = maxArray[i-1].coerceAtLeast(nums[i])
            minArray[size-i-1] = minArray[size-i].coerceAtMost(nums[size-i-1])
        }

        var resultStartIdx = -1
        var resultEndIdx = -1
        for (i in 0 until size) {
            if (maxArray[size-i-1] > nums[size-i-1]) {
                resultEndIdx = size-i-1
                break
            }
        }
        for (i in 0 until size) {
            if (minArray[i] < nums[i]) {
                resultStartIdx = i
                break
            }
        }

        if (resultStartIdx == -1) return 0
        return resultEndIdx - resultStartIdx + 1
    }

    override val givenTestCases: Map<String, Int> = mapOf(
        "[2,6,4,8,10,9,15]" to 5,
        "[1,2,3,4]" to 0,
        "[1]" to 0
    )

    override fun inputStringToInputType(input: String): IntArray = input.toIntArray()
    override fun algorithm(input: IntArray): Int = findUnsortedSubarray(input)
}