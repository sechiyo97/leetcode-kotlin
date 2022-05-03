package solution

import Solution
import common.toIntArray

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
class Sol_34_find_first_and_last_position_of_element_in_sorted_array: Solution.General<Sol_34_find_first_and_last_position_of_element_in_sorted_array.Params, IntArray>() {
    /**
     * Solution #2
     * Binary Search
     */
    fun searchRange(nums: IntArray, target: Int): IntArray {
        // find target
        val result = intArrayOf(-1,-1)
        if (nums.isEmpty()) return result

        var left = 0
        var right = nums.size-1
        var cur = (left+right)/2

        var found = false
        while (left<=right) {
            when {
                nums[cur] > target -> right = cur-1
                nums[cur] < target -> left = cur+1
                else -> found = true
            }
            if (found) break
            cur = (left+right)/2
        }

        if (found.not()) return result
        result[0] = cur
        result[1] = cur

        // find first appearance
        left = 0
        right = cur
        found = false
        var start = (left+right)/2
        while (left<=right) {
            when {
                nums[start] != target -> left = start+1
                else -> if (start == 0 || nums[start-1] != target) found = true else right = start-1
            }
            if (found) break
            start = (left+right)/2
        }
        if (found) result[0] = start

        // find last appearance
        left = cur
        right = nums.size-1
        found = false
        var end = (left+right)/2
        while (left<=right) {
            when {
                nums[end] != target -> right = end-1
                else -> if (end == nums.size-1 || nums[end+1] != target) found = true else left = end+1
            }
            if (found) break
            end = (left+right)/2
        }
        if (found) result[1] = end

        return result
    }

    /**
     * Solution #1
     * Linear Search
     */
//    fun searchRange(nums: IntArray, target: Int): IntArray {
//        var startPos = -1
//        var endPos = -1
//        for (i in nums.indices) {
//            if (nums[i] == target) {
//                startPos = i
//                break
//            }
//        }
//        for (i in nums.indices) {
//            if (nums[nums.size-i-1] == target) {
//                endPos = nums.size-i-1
//                break
//            }
//        }
//        return intArrayOf(startPos, endPos)
//    }

    override val givenTestCases: Map<String, IntArray> = mapOf(
        "[5,7,7,8,8,10] 8" to intArrayOf(3,4),
        "[5,7,7,8,8,10] 6" to intArrayOf(-1,-1),
        "[] 0" to intArrayOf(-1,-1)
    )

    override val customTestCases: Map<String, IntArray> = mapOf(
        "[1] 1" to intArrayOf(0,0),
        "[1,2,3,4] 3" to intArrayOf(2,2),
        "[1] 0" to intArrayOf(-1,-1)
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