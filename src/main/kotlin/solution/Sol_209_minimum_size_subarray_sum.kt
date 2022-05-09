package solution

import Solution
import common.toIntArray

class Sol_209_minimum_size_subarray_sum: Solution.General<Sol_209_minimum_size_subarray_sum.Params, Int>() {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var minSize = 100000
        var sum = 0
        var start = 0
        var end = 0
        while (end < nums.size) {
            sum += nums[end]
            while (start < end) {
                if (sum - nums[start] >= target) {
                    sum -= nums[start]
                    start++
                }
                else break
            }
            end++
            if (sum >= target && end-start < minSize) minSize = end-start
        }
        return if (minSize > nums.size) 0 else minSize
    }

    override val givenTestCases: Map<String, Int> = mapOf(
        "7 [2,3,1,2,4,3]" to 2,
        "4 [1,4,4]" to 1,
        "11 [1,1,1,1,1,1,1,1]" to 0
    )

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        val target = split[0].toInt()
        val nums = split[1].toIntArray()
        return Params(target, nums)
    }
    override fun algorithm(input: Params): Int = minSubArrayLen(input.target, input.nums)
    class Params(val target: Int, val nums: IntArray)
}