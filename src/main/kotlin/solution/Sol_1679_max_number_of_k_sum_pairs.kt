package solution

import Solution
import common.toIntArray

class Sol_1679_max_number_of_k_sum_pairs: Solution.General<Sol_1679_max_number_of_k_sum_pairs.Params, Int>() {
    fun maxOperations(nums: IntArray, k: Int): Int {
        return 1
    }

    override val givenTestCases: Map<String, Int> = mapOf(
        "[1,2,3,4] 5" to 2,
        "[3,1,3,4,3] 6" to 1
    )

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        val nums = split[0].toIntArray()
        val k = split[1].toInt()
        return Params(nums, k)
    }
    override fun algorithm(input: Params): Int= maxOperations(input.nums, input.k)
    class Params(val nums: IntArray, val k: Int)
}