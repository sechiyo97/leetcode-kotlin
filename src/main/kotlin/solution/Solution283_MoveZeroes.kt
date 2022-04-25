package solution

import Solution
import common.toIntArray

// must use same variable for input and output
class Solution283_MoveZeroes: Solution<IntArray, IntArray>() {
    override val givenTestCases: Map<String, IntArray> = mapOf(
        "[0,1,0,3,12]" to intArrayOf(1,3,12,0,0),
        "[0]" to intArrayOf(0)
    )

    override fun algorithm(params: IntArray): IntArray {
        return params // no return value in actual problem
    }

    override fun inputToParamType(input: String): IntArray {
        return input.toIntArray()
    }
}
