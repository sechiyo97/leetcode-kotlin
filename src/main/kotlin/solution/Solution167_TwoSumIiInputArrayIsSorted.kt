package solution

import common.toIntArray

class Solution167_TwoSumIiInputArrayIsSorted: Solution.General<Solution167_TwoSumIiInputArrayIsSorted.Params, IntArray>(){
    class Params(val numbers: IntArray, val target: Int)

    override val givenTestCases: Map<String, IntArray> = mapOf(
        "[2,7,11,15] 9" to intArrayOf(1,2),
        "[2,3,4] 6" to intArrayOf(1,3),
        "[-1,0] -1" to intArrayOf(1,2)
    )

    override fun algorithm(input: Params): IntArray {
        return input.numbers
    }

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        return Params(split[0].toIntArray(), split[1].toInt())
    }

}


