package solution

import Solution
import common.to2DIntArray

class Solution876_TheKWeakestRowsInAMatrix: Solution<Solution876_TheKWeakestRowsInAMatrix.Params, IntArray>() {
    class Params(val mat: Array<IntArray>, val k: Int)

    override val givenTestCases: Map<String, IntArray> =  mapOf(
        "[[1,1,0,0,0],[1,1,1,1,0],[1,0,0,0,0],[1,1,0,0,0],[1,1,1,1,1]] 3" to intArrayOf(2,0,3),
        "[[1,0,0,0],[1,1,1,1],[1,0,0,0],[1,0,0,0]] 2" to intArrayOf(0,2)
    )

    override fun algorithm(params: Params): IntArray {
        val mat = params.mat
        val k = params.k

        val matWithIndex = mat.mapIndexed { index, ints -> Pair(index, ints) }
        val sorted = matWithIndex.sortedBy {
            it.second.count { value -> value == 1 }
        }

        val answer = sorted.take(k).map { it.first }.toIntArray()
        return answer
    }

    override fun inputToParamType(input: String): Params {
        val split = input.split(" ")
        return Params(split[0].to2DIntArray(), split[1].toInt())
    }
}
