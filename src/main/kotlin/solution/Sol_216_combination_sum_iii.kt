package solution

import Solution

class Sol_216_combination_sum_iii: Solution.General<Sol_216_combination_sum_iii.Params, List<List<Int>>>() {
    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        return combinationMinVal(k, n, 1)
    }

    private fun combinationMinVal(k: Int, n: Int, min: Int): List<List<Int>> {
        if (k==1) return if (n in min..9) listOf(listOf(n)) else listOf()
        val result = mutableListOf<List<Int>>()
        for (i in min until (n/k+1).coerceAtMost(9)) {
            val subResult = mutableListOf<List<Int>>()
            combinationMinVal(k-1, n-i, i+1).forEach {
                val single = it.toMutableList()
                single.add(0, i)
                subResult.add(single)
            }
            result.addAll(subResult)
        }
        return result
    }

    override val givenTestCases: Map<String, List<List<Int>>> = mapOf(
        "3 7" to listOf(listOf(1,2,4)),
        "3 9" to listOf(listOf(1,2,6), listOf(1,3,5), listOf(2,3,4)),
        "4 1" to listOf()
    )
    override val customTestCases: Map<String, List<List<Int>>> = mapOf(
        "2 18" to listOf()
    )

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        return Params(split[0].toInt(), split[1].toInt())
    }
    override fun algorithm(input: Params): List<List<Int>> = combinationSum3(input.k, input.n)
    class Params(val k: Int, val n: Int)
}