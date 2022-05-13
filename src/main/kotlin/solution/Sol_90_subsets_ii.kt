package solution

import Solution
import common.toIntArray

class Sol_90_subsets_ii: Solution.General<IntArray, List<List<Int>>>() {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val result = mutableSetOf<List<Int>>()
        val path = mutableListOf<Int>()
        result.add(path.sorted())
        for (i in nums.indices) {
            subsetsFrom(nums, i, path, result)
        }
        return result.toList()
    }

    private fun subsetsFrom(nums: IntArray, start: Int, path: MutableList<Int>, result: MutableSet<List<Int>>) {
        val target = nums[start]
        path.add(nums[start])
        result.add(path.sorted())
        for (i in start+1 until nums.size) {
            subsetsFrom(nums, i, path, result)
        }
        path.remove(target)
    }

    override val givenTestCases: Map<String, List<List<Int>>> = mapOf(
        "[1,2,2]" to listOf(listOf(), listOf(1), listOf(1,2), listOf(1,2,2), listOf(2), listOf(2,2)),
        "[0]" to listOf(listOf(), listOf(0))
    )
    override val customTestCases: Map<String, List<List<Int>>> = mapOf(
        "[4,4,4,1,4]" to listOf(listOf(), listOf(1), listOf(1,4), listOf(1,4,4), listOf(1,4,4,4), listOf(1,4,4,4,4), listOf(4), listOf(4,4), listOf(4,4,4), listOf(4,4,4,4))
    )
    override fun inputStringToInputType(input: String): IntArray = input.toIntArray()
    override fun algorithm(input: IntArray): List<List<Int>> = subsetsWithDup(input)
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