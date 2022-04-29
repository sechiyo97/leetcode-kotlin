package solution

import Solution
import common.checkContentEquals
import common.convertToString
import common.to2DIntArray

class Sol_77_combinations : Solution.General<Sol_77_combinations.Params, List<List<Int>>>() {
    data class Params(val n: Int, val k: Int)

    override val givenTestCases: Map<String, List<List<Int>>> = mapOf(
        "4 2" to "[[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]".to2DIntArray().map { it.map { value -> value } },
        "1 1" to "[[1]]".to2DIntArray().map { it.map { value -> value } }
    )

    override fun algorithm(input: Params): List<List<Int>> {
        val n = input.n
        val k = input.k

        return getSubLists(0, n, k)
    }

    private fun getSubLists(start: Int, end: Int, count: Int): MutableList<MutableList<Int>> {
        if (count == 1) return (start until end).map { mutableListOf(it + 1) }.toMutableList()

        val results = mutableListOf<MutableList<Int>>()
        for (i in start until end - count) {
            val resultStartsWithI = getSubLists(i + 1, end, count - 1).map { it.apply { it.add(0, i + 1) } }
            results.addAll(resultStartsWithI)
        }
        results.add((end - count until end).map { it + 1 }.toMutableList())
        return results
    }

    override fun checkEquals(result: List<List<Int>>, expected: List<List<Int>>?): Boolean {
        val sortedResult = result
            .map { it.sortedBy { value -> value }.toIntArray() }
            .filterNot { it.isEmpty() }
            .sortedWith (compareBy({ it[0] }, { it.sum() }))
            .sortedBy { it.sum() }
            .toTypedArray()
        val sortedExpected = expected
            ?.map { it.sortedBy { value -> value }.toIntArray() }
            ?.filterNot { it.isEmpty() }
            ?.sortedWith (compareBy({ it[0] }, { it.sum() }))
            ?.toTypedArray()
        return sortedResult.checkContentEquals(sortedExpected)
    }

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        return Params(split[0].toInt(), split[1].toInt())
    }
}