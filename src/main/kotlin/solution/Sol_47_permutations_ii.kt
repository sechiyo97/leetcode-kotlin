package solution

import Solution
import common.toIntArray

class Sol_47_permutations_ii: Solution.General<IntArray, List<List<Int>>>() {
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        return result
    }

    override val givenTestCases: Map<String, List<List<Int>>> = mapOf(
        "[1,1,2]" to listOf(listOf(1,1,2), listOf(1,2,1), listOf(2,1,1)),
        "[1,2,3]" to listOf(listOf(1,2,3), listOf(1,3,2), listOf(2,1,3), listOf(3,1,2), listOf(3,2,1), listOf(3,2,1))
    )
    override fun inputStringToInputType(input: String): IntArray = input.toIntArray()
    override fun algorithm(input: IntArray): List<List<Int>> = permuteUnique(input)

    override fun checkEquals(result: List<List<Int>>, expected: List<List<Int>>?): Boolean {
        result.forEach {
            if ((expected?.contains(it) == true).not()) return false
        }
        expected?.forEach {
            if ((result.contains(it)).not()) return false
        }
        return true
    }
}