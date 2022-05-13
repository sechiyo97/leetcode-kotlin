package solution

import Solution
import common.toIntArray

class Sol_40_combination_sum_ii: Solution.General<Sol_40_combination_sum_ii.Params, List<List<Int>>>() {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val counts = IntArray(50)
        candidates.forEach { counts[it-1]++ }
        val result = mutableListOf<List<Int>>()
        val selected = mutableListOf<Int>()
        dfs(counts, target, selected, 0, 0, result)
        return result.toSet().toList()
    }

    private fun dfs(counts: IntArray, target: Int, path: MutableList<Int>, sum: Int, nextMinIndex: Int, result: MutableList<List<Int>>) {
        if (sum > target) return
        if (sum == target) {
            result.add(path.toList())
            return
        }
        for (i in nextMinIndex until counts.size) {
            val num = i+1
            val cnt = counts[i]
            var newSum = sum
            for (j in 1..cnt) {
                path.add(num)
                counts[i] -= j
                newSum += (num*j)
                dfs(counts, target, path, newSum, i+1, result)
                newSum -= (num*j)
                counts[i] += j
            }
            for (k in 0 until cnt) path.removeAt(path.size-1)
        }
    }

    override val givenTestCases: Map<String, List<List<Int>>> = mapOf(
        "[10,1,2,7,6,1,5] 8" to listOf(listOf(1,1,6), listOf(1,2,5), listOf(1,7), listOf(2,6)),
        "[2,5,2,1,2] 5" to listOf(listOf(1,2,2), listOf(5)),
    )

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        val candidates = split[0].toIntArray()
        val target = split[1].toInt()
        return Params(candidates, target)
    }
    override fun algorithm(input: Params): List<List<Int>> = combinationSum2(input.candidates, input.target)
    class Params(val candidates: IntArray, val target: Int)

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