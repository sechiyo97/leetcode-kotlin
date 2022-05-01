package solution

import Solution
import common.toIntArray

// https://leetcode.com/problems/maximum-subarray/
class Sol_53_maximum_subarray: Solution.General<IntArray, Int>() {
    fun maxSubArray(nums: IntArray): Int {
        var maxSum = -10000
        var sum = 0
        nums.forEach { current ->
            val calculatedSum = sum + current
            when {
                calculatedSum < 0 -> {
                    maxSum = maxOf(maxSum, calculatedSum)
                    sum = 0
                }
                calculatedSum < sum -> {
                    maxSum = maxOf(maxSum, sum)
                    sum = calculatedSum
                }
                else -> {
                    sum = calculatedSum
                    maxSum = maxOf(maxSum, sum)
                }
            }
        }
        return maxSum
    }

    override val givenTestCases: Map<String, Int> = mapOf(
        "[-2,1,-3,4,-1,2,1,-5,4]" to 6,
        "[1]" to 1,
        "[5,4,-1,7,8]" to 23
    )

    override fun algorithm(input: IntArray): Int = maxSubArray(input)
    override fun inputStringToInputType(input: String): IntArray {
        return input.toIntArray()
    }
}
