package solution

import common.checkContentEquals
import common.to2DIntArray
import common.toIntArray

// https://leetcode.com/problems/permutations/
class Sol_46_permutations: Solution.General<IntArray, List<List<Int>>>() {
    fun permute(nums: IntArray): List<List<Int>> {
        return subPermute(nums.toMutableList())
    }

    private fun subPermute(arr: MutableList<Int>): List<MutableList<Int>> {
        if (arr.size == 1) return mutableListOf(mutableListOf(arr[0]))

        val results = mutableListOf<MutableList<Int>>()
        for (i in 0 until arr.size) {
            val popped = arr.removeAt(i)
            val resultExceptIth = subPermute(arr)
            arr.add(i, popped)
            resultExceptIth.forEach { it.add(0, arr[i]) }
            results.addAll(resultExceptIth)
        }
        return results
    }


    override val givenTestCases: Map<String, List<List<Int>>> = mapOf(
        "[1,2,3]" to "[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]".to2DIntArray().map { it.map { value -> value } },
        "[0,1]" to "[[0,1],[1,0]]".to2DIntArray().map { it.map { value -> value } },
        "[1]" to "[[1]]".to2DIntArray().map { it.map { value -> value } }
    )

    override fun algorithm(input: IntArray): List<List<Int>> = permute(input)
    override fun inputStringToInputType(input: String): IntArray {
        return input.toIntArray()
    }

    override fun checkEquals(result: List<List<Int>>, expected: List<List<Int>>?): Boolean {
        val sortedResult = result
            .map { it.toIntArray() }
            .filterNot { it.isEmpty() }
            .sortedWith (compareBy({ it[0] }, { it.sum() }))
            .toTypedArray()
        val sortedExpected = expected
            ?.map { it.toIntArray() }
            ?.filterNot { it.isEmpty() }
            ?.sortedWith (compareBy({ it[0] }, { it.sum() }))
            ?.toTypedArray()
        return sortedResult.checkContentEquals(sortedExpected)
    }
}