package solution

import Solution
import common.toIntArray

class Solution283_MoveZeroes: Solution.InPlaceArray<IntArray, IntArray>() {
    override val givenTestCases: Map<String, IntArray> = mapOf(
        "[0,1,0,3,12]" to intArrayOf(1,3,12,0,0),
        "[0]" to intArrayOf(0)
    )

    override fun algorithm(input: IntArray) {
    }

    override fun inputStringToInputType(input: String): IntArray {
        return input.toIntArray()
    }
    override fun inputTypeToArrayType(input: IntArray): IntArray {
        return input
    }

}
