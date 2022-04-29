package solution

import common.checkContentEquals
import common.convertToString
import common.to2DIntArray
import common.toIntArray
import kotlin.math.exp

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
        val sortedResult = result.map { it.sortedBy { it }.toIntArray()}.sortedBy { it[0] }.toTypedArray()
        val sortedExpected = expected?.map { it.sortedBy { it }.toIntArray()}?.sortedBy { it[0] }?.toTypedArray()
        val pass = sortedResult.checkContentEquals(sortedExpected)
        return pass
    }

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        return Params(split[0].toInt(), split[1].toInt())
    }
}