package solution

import Solution
import common.swap
import common.toIntArray

// https://leetcode.com/problems/remove-element/
class Sol_27_remove_element: Solution.General<Sol_27_remove_element.Params, Int>() {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var k = 0
        for (i in nums.indices) {
            if (nums[i] != `val`) {
                nums[k] = nums[i]
                k++
            }
        }
        return k
    }

    override val givenTestCases: Map<String, Int> = mapOf(
        "[3,2,2,3] 3" to 2,
        "[0,1,2,2,3,0,4,2] 2" to 5
    )

    override val customTestCases: Map<String, Int> = mapOf(
    )

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        val nums = split[0].toIntArray()
        val k = split[1].toInt()
        return Params(nums, k)
    }
    override fun algorithm(input: Params): Int= removeElement(input.nums, input.k)
    class Params(val nums: IntArray, val k: Int)
}
