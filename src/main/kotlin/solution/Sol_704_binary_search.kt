package solution

import Solution
import common.algorithm.binarySearch
import common.toIntArray

class Sol_704_binary_search: Solution.General<Sol_704_binary_search.Params, Int>() {
    class Params(val nums: IntArray, val target: Int)

    override val givenTestCases: Map<String, Int> = mapOf(
        "[-1,0,3,5,9,12] 9" to 4,
        "[-1,0,3,5,9,12] 2" to -1
    )

    override fun algorithm(input: Params): Int {
        val nums = input.nums
        val target = input.target

        return binarySearch(nums, target)
    }

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        return Params(split[0].toIntArray(), split[1].toInt())
    }
}