package solution

import Solution
import common.toIntArray

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
class Sol_26_remove_duplicates_from_sorted_array: Solution.General<Sol_26_remove_duplicates_from_sorted_array.Params, Int>() {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        var i = 1
        for (j in 1 until nums.size) {
            if (nums[j] != nums[i-1]) {
                nums[i] = nums[j]
                i++
            }
        }
        return i
    }

    override val givenTestCases: Map<String, Int> = mapOf(
        "[1,1,2]" to 2,
        "[0,0,1,1,1,2,2,3,3,4]" to 5
    )

    override val customTestCases: Map<String, Int> = mapOf(
    )

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        val nums = split[0].toIntArray()
        return Params(nums)
    }
    override fun algorithm(input: Params): Int= removeDuplicates(input.nums)
    class Params(val nums: IntArray)
}
