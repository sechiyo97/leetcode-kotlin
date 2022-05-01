package solution

import Solution
import common.toIntArray

// https://leetcode.com/problems/squares-of-a-sorted-array/
class Sol_977_squares_of_a_sorted_array: Solution.General<IntArray, IntArray>() {
    fun sortedSquares(nums: IntArray): IntArray {
        val n = nums.size
        val result = IntArray(n)
        var writeIndex = 0

        // find first positive index
        var posIndex = 0
        while(posIndex<n) {
            if (nums[posIndex] >= 0) break
            posIndex++
        }
        var negIndex = posIndex-1

        // move pointers to find smaller absolute value
        while(negIndex >=0 || posIndex < n) {
            when {
                posIndex >= n -> {
                    result[writeIndex] = nums[negIndex] * nums[negIndex]
                    negIndex--
                }
                negIndex < 0 -> {
                    result[writeIndex] = nums[posIndex]*nums[posIndex]
                    posIndex++
                }
                -nums[negIndex] > nums[posIndex] -> {
                    result[writeIndex] = nums[posIndex]*nums[posIndex]
                    posIndex++
                }
                else -> {
                    result[writeIndex] = nums[negIndex]*nums[negIndex]
                    negIndex--
                }
            }
            writeIndex++
        }

        return result
    }

    override val givenTestCases: Map<String, IntArray> = mapOf(
        "[-4,-1,0,3,10]" to intArrayOf(0,1,9,16,100),
        "[-7,-3,2,3,11]" to intArrayOf(4,9,9,49,121)
    )
    override val customTestCases: Map<String, IntArray> = mapOf(
        "[-1]" to intArrayOf(1)
    )

    override fun algorithm(input: IntArray): IntArray = sortedSquares(input)
    override fun inputStringToInputType(input: String): IntArray {
        return input.toIntArray()
    }
}
