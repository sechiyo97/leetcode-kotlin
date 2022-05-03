package solution

import Solution
import common.toIntArray

// https://leetcode.com/problems/search-in-rotated-sorted-array/
class Sol_33_search_in_rotated_sorted_array: Solution.General<Sol_33_search_in_rotated_sorted_array.Params, Int>() {
    fun search(nums: IntArray, target: Int): Int {
        return 0
    }

    override val givenTestCases: Map<String, Int> = mapOf(
        "[4,5,6,7,0,1,2] 0" to 4,
        "[4,5,6,7,0,1,2] 3" to -1,
        "[1] 0" to -1
    )

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        val nums = split[0].toIntArray()
        val target = split[1].toInt()
        return Params(nums, target)
    }
    override fun algorithm(input: Params): Int = search(input)
    class Params(val nums: IntArray, val target: Int)
}