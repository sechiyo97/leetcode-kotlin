package solution

import Solution
import common.toIntArray

class Sol_153_find_minimum_in_rotated_soted_array: Solution.General<IntArray, Int>() {
    fun findMin(nums: IntArray): Int {
        var left = 0
        var right = nums.size-1

        while (left < right) {
            val mid = (left+right)/2
            if (nums[mid] < nums[right]) right = mid
            else left = mid + 1
        }
        return nums[left]
    }

    override val givenTestCases: Map<String, Int> = mapOf(
        "[3,4,5,1,2]" to 1,
        "[4,5,6,7,0,1,2]" to 0,
        "[11,13,15,17]" to 11
    )
    override val customTestCases: Map<String, Int> = mapOf(
        "[2,1]" to 1
    )

    override fun inputStringToInputType(input: String): IntArray = input.toIntArray()
    override fun algorithm(input: IntArray): Int = findMin(input)
}