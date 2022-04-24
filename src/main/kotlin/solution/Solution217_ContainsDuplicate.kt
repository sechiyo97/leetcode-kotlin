package solution

import Solution
import common.toIntArray

class Solution217_ContainsDuplicate: Solution<IntArray, Boolean>() {
    override val givenTestCases: Map<String, Boolean> = mapOf(
        "[1,2,3,1]" to true,
        "[1,2,3,4]" to false,
        "[1,1,1,3,3,4,3,2,4,2]" to true
    )

    override fun algorithm(params: IntArray): Boolean {
        val map = mutableMapOf<Int, Boolean>()
        params.forEach {
            if (map.containsKey(it)) return true
            else map[it] = true
        }
        return false
    }

    override fun inputToParamType(input: String): IntArray {
        return input.toIntArray()
    }
}
