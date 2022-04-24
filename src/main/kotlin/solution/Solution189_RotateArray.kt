package solution

import Solution
import common.toIntArray

// must use same variable for input and output
class Solution189_RotateArray: Solution<Solution189_RotateArray.Params, IntArray>(){
    class Params(val nums: IntArray, val k: Int)

    override val givenTestCases: Map<String, IntArray> = mapOf(
        "[1,2,3,4,5,6,7] 3" to intArrayOf(5,6,7,1,2,3,4),
        "[-1,-100,3,99] 2" to intArrayOf(3,99,-1,100)
    )

    override fun algorithm(params: Params): IntArray {
        return params.nums // no return value in actual problem
    }

    override fun inputToParamType(input: String): Params {
        val split = input.split(" ")
        val nums = split[0].toIntArray()
        val k = split[1].toInt()
        return Params(nums, k)
    }
}
