package solution

import Solution
import common.to2DIntArray

class Sol_797_all_paths_from_source_to_target: Solution.General<Array<IntArray>, List<List<Int>>>() {
    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
        val result: MutableList<List<Int>> = mutableListOf()
        val path: MutableList<Int> = mutableListOf()
        path.add(0)
        dfs(graph, 0, path, result)
        return result
    }

    private fun dfs(graph: Array<IntArray>, index: Int, path: MutableList<Int>, result: MutableList<List<Int>>) {
        if (index == graph.size - 1) {
            result.add(path.toList())
            return
        }
        graph[index].forEach { neighbor ->
            path.add(neighbor)
            dfs(graph, neighbor, path, result)
            path.removeAt(path.size-1)
        }
    }

    override val givenTestCases: Map<String, List<List<Int>>> = mapOf(
        "[[1,2],[3],[3],[]]" to listOf(listOf(0,1,3), listOf(0,2,3)),
        "[[4,3,1],[3,2,4],[3],[4],[]]" to listOf(listOf(0,4), listOf(0,3,4), listOf(0,1,3,4), listOf(0,1,2,3,4), listOf(0,1,4))
    )

    override fun inputStringToInputType(input: String): Array<IntArray> = input.to2DIntArray()
    override fun algorithm(input: Array<IntArray>): List<List<Int>> = allPathsSourceTarget(input)
}