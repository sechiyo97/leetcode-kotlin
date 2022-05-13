package solution

import Solution
import common.toIntArray

class Sol_78_subsets: Solution.General<IntArray, List<List<Int>>>() {
    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val path = mutableListOf<Int>()
        result.add(path)
        for (i in nums.indices) {
            subsetsFrom(nums, i, path, result)
        }
        return result
    }

    private fun subsetsFrom(nums: IntArray, start: Int, path: MutableList<Int>, result: MutableList<List<Int>>) {
        path.add(nums[start])
        result.add(path.toList())
        for (i in start+1 until nums.size) {
            subsetsFrom(nums, i, path, result)
        }
        path.removeAt(path.size-1)
    }

    override val givenTestCases: Map<String, List<List<Int>>> = mapOf(
        "[1,2,3]" to listOf(listOf(), listOf(1), listOf(2), listOf(1,2), listOf(3), listOf(1,3), listOf(2,3), listOf(1,2,3)),
        "[0]" to listOf(listOf(), listOf(0))
    )
    override fun inputStringToInputType(input: String): IntArray = input.toIntArray()
    override fun algorithm(input: IntArray): List<List<Int>> = subsets(input)
    override fun checkEquals(result: List<List<Int>>, expected: List<List<Int>>?): Boolean {
        expected ?: return false

        val resultSorted = result.map { it.sorted() }
        val expectedSorted = expected.map { it.sorted() }
        resultSorted.forEach {
            if ((it in expectedSorted).not()) return false
        }
        expectedSorted.forEach {
            if ((it in resultSorted).not()) return false
        }
        return true
    }
}