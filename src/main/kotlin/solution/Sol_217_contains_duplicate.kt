package solution

import Solution
import common.toIntArray

class Sol_217_contains_duplicate: Solution.General<IntArray, Boolean>() {
    override val givenTestCases: Map<String, Boolean> = mapOf(
        "[1,2,3,1]" to true,
        "[1,2,3,4]" to false,
        "[1,1,1,3,3,4,3,2,4,2]" to true
    )

    override fun algorithm(input: IntArray): Boolean {
        val map = mutableMapOf<Int, Boolean>()
        input.forEach {
            if (map.containsKey(it)) return true
            else map[it] = true
        }
        return false
    }

    override fun inputStringToInputType(input: String): IntArray {
        return input.toIntArray()
    }
}
