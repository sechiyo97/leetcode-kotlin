package solution

import Solution
import common.toIntArray

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
class Sol_34_find_first_and_last_position_of_element_in_sorted_array: Solution.General<Sol_34_find_first_and_last_position_of_element_in_sorted_array.Params, IntArray>() {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        var startPos = -1
        var endPos = -1
        for (i in nums.indices) {
            if (nums[i] == target) {
                startPos = i
                break
            }
        }
        for (i in nums.indices) {
            if (nums[nums.size-i-1] == target) {
                endPos = nums.size-i-1
                break
            }
        }
        return intArrayOf(startPos, endPos)
    }


    override val givenTestCases: Map<String, IntArray> = mapOf(
        "[5,7,7,8,8,10] 8" to intArrayOf(3,4),
        "[5,7,7,8,8,10] 6" to intArrayOf(-1,-1),
        "[] 0" to intArrayOf(-1,-1)
    )

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        val nums = split[0].toIntArray()
        val target = split[1].toInt()
        return Params(nums, target)
    }
    override fun algorithm(input: Params): IntArray = searchRange(input.nums, input.target)
    class Params(val nums: IntArray, val target: Int)
}