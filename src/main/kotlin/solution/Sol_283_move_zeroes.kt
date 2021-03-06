package solution

import Solution
import common.toIntArray
import java.util.LinkedList

// https://leetcode.com/problems/move-zeroes/
class Sol_283_move_zeroes: Solution.InPlaceArray<IntArray, IntArray>() {
    fun moveZeroes(nums: IntArray): Unit {
        val zeroIndexQueue = LinkedList<Int>()
        for (i in nums.indices) {
            if (nums[i] == 0) zeroIndexQueue.offer(i)
            else {
                val targetZeroIndex = zeroIndexQueue.poll() ?: continue
                val temp = nums[i]
                nums[i] = nums[targetZeroIndex]
                nums[targetZeroIndex] = temp
                zeroIndexQueue.offer(i)
            }
        }
    }

    override val givenTestCases: Map<String, IntArray> = mapOf(
        "[0,1,0,3,12]" to intArrayOf(1,3,12,0,0),
        "[0]" to intArrayOf(0)
    )

    override fun algorithm(input: IntArray) = moveZeroes(input)
    override fun inputStringToInputType(input: String): IntArray {
        return input.toIntArray()
    }
    override fun getTargetArrayFromInput(input: IntArray): IntArray {
        return input
    }
}
