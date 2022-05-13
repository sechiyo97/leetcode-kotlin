package solution

import Solution
import common.toIntArray

class Sol_39_combination_sum: Solution.General<Sol_39_combination_sum.Params, List<List<Int>>>() {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val path = mutableListOf<Int>()
        dfs(candidates.toMutableList(), target, path, 0, 0, result)
        return result
    }

    private fun dfs(candidates: List<Int>, target: Int, path: MutableList<Int>, sum: Int, lastIndex: Int, result: MutableList<List<Int>>) {
        if (sum > target) return
        if (sum == target) {
            result.add(path.toList())
            return
        }
        for (i in lastIndex until candidates.size) {
            path.add(candidates[i])
            dfs(candidates, target, path, sum+path[path.size-1], i, result)
            path.removeAt(path.size-1)
        }
    }

    override val givenTestCases: Map<String, List<List<Int>>> = mapOf(
        "[2,3,6,7] 7" to listOf(listOf(2,2,3), listOf(7)),
        "[2,3,5] 8" to listOf(listOf(2,2,2,2), listOf(2,3,3), listOf(3,5)),
        "[2] 1" to listOf()
    )

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        val candidates = split[0].toIntArray()
        val target = split[1].toInt()
        return Params(candidates, target)
    }
    override fun algorithm(input: Params): List<List<Int>> = combinationSum(input.candidates, input.target)
    class Params(val candidates: IntArray, val target: Int)
}