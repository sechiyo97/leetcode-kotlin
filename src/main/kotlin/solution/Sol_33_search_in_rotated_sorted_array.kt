package solution

import Solution
import common.toIntArray

// https://leetcode.com/problems/search-in-rotated-sorted-array/
class Sol_33_search_in_rotated_sorted_array: Solution.General<Sol_33_search_in_rotated_sorted_array.Params, Int>() {
    fun search(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) return -1

        val first = nums[0]
        val last = nums[nums.size-1]
        if (first == target) return 0
        if (last == target) return nums.size-1

        var left = 0
        var right = nums.size-1
        var mid = (left+right)/2

        var cnt =0
        while (mid != left && mid != right) {
            cnt++
            val current = nums[mid]
            val toRight = when {
                current < target -> if (current < first) target < first else true
                current > target -> if (current > first) target < first else false
                else -> return mid
            }
            if (toRight) left = mid
            else right = mid
            mid = (left+right)/2
        }

        return -1
    }

    override val givenTestCases: Map<String, Int> = mapOf(
        "[4,5,6,7,0,1,2] 0" to 4,
        "[4,5,6,7,0,1,2] 3" to -1,
        "[1] 0" to -1
    )
    override val customTestCases: Map<String, Int> = mapOf("[5,1,2,3,4] 1" to 1)

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        val nums = split[0].toIntArray()
        val target = split[1].toInt()
        return Params(nums, target)
    }
    override fun algorithm(input: Params): Int = search(input.nums, input.target)
    class Params(val nums: IntArray, val target: Int)
}