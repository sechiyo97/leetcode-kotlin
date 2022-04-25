package solution

import Solution
import common.toIntArray

class Solution977_SquaresOfASortedArray: Solution<IntArray, IntArray>() {
    override val givenTestCases: Map<String, IntArray> = mapOf(
        "[-4,-1,0,3,10]" to intArrayOf(0,1,9,16,100),
        "[-7,-3,2,3,11]" to intArrayOf(4,9,9,49,121)
    )

    override fun algorithm(params: IntArray): IntArray {
        return params
    }

    override fun inputToParamType(input: String): IntArray {
        return input.toIntArray()
    }
}
