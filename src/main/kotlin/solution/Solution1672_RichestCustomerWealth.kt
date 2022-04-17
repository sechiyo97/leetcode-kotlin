package solution

import Solution
import common.to2DIntArray

class Solution1672_RichestCustomerWealth: Solution<Array<IntArray>, Int>() {
    override val givenTestCases = mapOf(
        "[[1,2,3],[3,2,1]]" to 6,
        "[[1,5],[7,3],[3,5]]" to 10,
        "[[2,8,7],[7,1,3],[1,9,5]" to 17
    )

    override fun algorithm(params: Array<IntArray>): Int {
        return params.map { it.sum() }.sorted().last()
    }

    override fun inputToParamType(input: String): Array<IntArray> {
        return input.to2DIntArray()
    }
}
