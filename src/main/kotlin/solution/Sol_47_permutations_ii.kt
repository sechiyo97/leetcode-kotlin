package solution

import Solution
import common.toIntArray

class Sol_47_permutations_ii: Solution.General<IntArray, List<List<Int>>>() {
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        val result: MutableList<List<Int>> = mutableListOf()
        dfs(nums.toMutableList(), mutableListOf(), result)
        return result.toSet().toList()
    }

    private fun dfs(nodes: MutableList<Int>, path: MutableList<Int>, result: MutableList<List<Int>>) {
        if (nodes.isEmpty()) {
            result.add(path.toList())
            return
        }
        for (i in nodes.indices) {
            path.add(nodes[i])
            nodes.removeAt(i)
            dfs(nodes, path, result)
            nodes.add(i, path[path.size-1])
            path.removeAt(path.size-1)
        }
    }

    override val givenTestCases: Map<String, List<List<Int>>> = mapOf(
        "[1,1,2]" to listOf(listOf(1,1,2), listOf(1,2,1), listOf(2,1,1)),
        "[1,2,3]" to listOf(listOf(1,2,3), listOf(1,3,2), listOf(2,1,3), listOf(2,3,1), listOf(3,1,2), listOf(3,2,1))
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