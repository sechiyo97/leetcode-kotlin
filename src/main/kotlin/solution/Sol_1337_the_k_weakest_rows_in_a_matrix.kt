package solution

import Solution
import common.to2DIntArray

// https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
class Sol_1337_the_k_weakest_rows_in_a_matrix: Solution.General<Sol_1337_the_k_weakest_rows_in_a_matrix.Params, IntArray>() {
    fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
        val matWithIndex = mat.mapIndexed { index, ints -> Pair(index, ints) }
        val sorted = matWithIndex.sortedBy {
            it.second.count { value -> value == 1 }
        }

        val answer = sorted.take(k).map { it.first }.toIntArray()
        return answer
    }

    override val givenTestCases: Map<String, IntArray> =  mapOf(
        "[[1,1,0,0,0],[1,1,1,1,0],[1,0,0,0,0],[1,1,0,0,0],[1,1,1,1,1]] 3" to intArrayOf(2,0,3),
        "[[1,0,0,0],[1,1,1,1],[1,0,0,0],[1,0,0,0]] 2" to intArrayOf(0,2)
    )

    override fun algorithm(input: Params): IntArray = kWeakestRows(input.mat, input.k)
    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        return Params(split[0].to2DIntArray(), split[1].toInt())
    }
    class Params(val mat: Array<IntArray>, val k: Int)
}
