package solution

import common.toIntArray
import kotlin.math.exp

// https://leetcode.com/problems/sort-array-by-parity/
class Sol_905_sort_array_by_parity: Solution.General<IntArray, IntArray>() {
    fun sortArrayByParity(nums: IntArray): IntArray {
        var left = 0
        var right = nums.size-1
        while (true) {
            while (left < nums.size && nums[left]%2 == 0) left++
            while (right >= 0 && nums[right]%2 != 0) right--

            if (right == -1 || left == nums.size || right < left) break

            nums[left] = nums[right].also { nums[right] = nums[left] }
            right--
            left++
        }
        return nums
    }

    override val givenTestCases: Map<String, IntArray> = mapOf(
        "[3,1,2,4]" to intArrayOf(2,4,3,1),
        "[0]" to intArrayOf(0),
        "[0,2]" to intArrayOf(0,2),
        "[0,1]" to intArrayOf(0,1)
    )

    override fun inputStringToInputType(input: String): IntArray = input.toIntArray()
    override fun algorithm(input: IntArray): IntArray = sortArrayByParity(input)
    override fun checkEquals(result: IntArray, expected: IntArray?): Boolean {
        if (result.size != expected?.size) return false
        for(i in result.indices) {
            if (result[i]%2 != expected[i]%2) return false
        }
        return true
    }
}