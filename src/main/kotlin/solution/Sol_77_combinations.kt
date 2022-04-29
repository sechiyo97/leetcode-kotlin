package solution

import Solution
import common.checkContentEquals
import common.to2DIntArray

class Sol_77_combinations: Solution.General<Sol_77_combinations.Params, List<List<Int>>>() {
    data class Params(val n: Int, val k: Int)

    override val givenTestCases: Map<String, List<List<Int>>> = mapOf(
        "4 2" to "[[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]".to2DIntArray().map { it.map { value -> value }},
        "1 1" to "[[1]]".to2DIntArray().map { it.map { value -> value }}
    )

    override fun algorithm(input: Params): List<List<Int>> {
        return listOf(listOf(1))
    }


    override fun checkEquals(result: List<List<Int>>, expected: List<List<Int>>?): Boolean {
        val sortedResult = result
            .map { it.sortedBy { value -> value }.toIntArray() }
            .filterNot { it.isEmpty() }
            .sortedBy { it[0] }
            .toTypedArray()
        val sortedExpected = expected
            ?.map { it.sortedBy { value -> value }.toIntArray() }
            ?.filterNot { it.isEmpty() }
            ?.sortedBy { it[0] }
            ?.toTypedArray()
        return sortedResult.checkContentEquals(sortedExpected)
    }

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        return Params(split[0].toInt(), split[1].toInt())
    }
}