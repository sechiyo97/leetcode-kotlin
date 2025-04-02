package solution

import Solution
import common.swap
import common.toIntArray

// https://leetcode.com/problems/next-permutation/
class Sol_31_next_permutation: Solution.General<IntArray, IntArray>() {
    fun nextPermutation(nums: IntArray): IntArray {
        val downsideIndexFromEnd = nums.indices.reversed().first { it <= 0 || nums[it] > nums[it-1] }
        if (downsideIndexFromEnd <= 0) {
            nums.sort()
        } else {
            val index1 = downsideIndexFromEnd - 1
            val index2 = nums.indices.reversed().first { nums[it] > nums[index1] }
            nums.swap(index1, index2)
            nums.sort(index1 + 1, nums.size)
        }
        return nums
    }

    override val givenTestCases: Map<String, IntArray> = mapOf(
        "[1,2,3]" to intArrayOf(1,3,2),
        "[3,2,1]" to intArrayOf(1,2,3),
        "[1,1,5]" to intArrayOf(1,5,1),
    )
    override val customTestCases: Map<String, IntArray> = mapOf(
        "[2,3,1]" to intArrayOf(3,1,2),
        "[1,3,2]" to intArrayOf(2,1,3),
    )

    override fun algorithm(input: IntArray): IntArray = nextPermutation(input)
    override fun inputStringToInputType(input: String): IntArray {
        return input.toIntArray()
    }
}
