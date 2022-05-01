package solution

import Solution
import common.toIntArray

// https://leetcode.com/problems/contains-duplicate/
class Sol_217_contains_duplicate: Solution.General<IntArray, Boolean>() {
    fun containsDuplicate(nums: IntArray): Boolean {
        val map = mutableMapOf<Int, Boolean>()
        nums.forEach {
            if (map.containsKey(it)) return true
            else map[it] = true
        }
        return false
    }

    override val givenTestCases: Map<String, Boolean> = mapOf(
        "[1,2,3,1]" to true,
        "[1,2,3,4]" to false,
        "[1,1,1,3,3,4,3,2,4,2]" to true
    )

    override fun algorithm(input: IntArray): Boolean = containsDuplicate(input)
    override fun inputStringToInputType(input: String): IntArray {
        return input.toIntArray()
    }
}
