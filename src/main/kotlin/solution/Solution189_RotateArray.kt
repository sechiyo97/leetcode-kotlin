package solution

import Solution
import common.toIntArray

// must use same variable for input and output
class Solution189_RotateArray: Solution<Solution189_RotateArray.Params, IntArray>(){
    class Params(val nums: IntArray, val k: Int)

    override val givenTestCases: Map<String, IntArray> = mapOf(
        "[1,2,3,4,5,6,7] 3" to intArrayOf(5,6,7,1,2,3,4),
        "[-1,-100,3,99] 2" to intArrayOf(3,99,-1,-100)
    )

    /**
     * Algorithm #1: create a new IntArray and put rotated values
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    override fun algorithm(params: Params): IntArray {
        val nums = params.nums
        val k = params.k

        val n = nums.size
        val newArray = IntArray(n)
        for (i in 0 until n) newArray[(i+k)%n] = nums[i]
        for (i in 0 until n) nums[i] = newArray[i]

        return nums // no return value in actual problem
    }

    override fun inputToParamType(input: String): Params {
        val split = input.split(" ")
        val nums = split[0].toIntArray()
        val k = split[1].toInt()
        return Params(nums, k)
    }
}
