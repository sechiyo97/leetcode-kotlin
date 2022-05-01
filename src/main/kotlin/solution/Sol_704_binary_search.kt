package solution

import Solution
import common.algorithm.binarySearch
import common.toIntArray

// https://leetcode.com/problems/binary-search/
class Sol_704_binary_search: Solution.General<Sol_704_binary_search.Params, Int>() {
    fun search(nums: IntArray, target: Int): Int {
        var min = 0
        var max = nums.lastIndex
        var mid = (min + max)/2
        while (max >= min) {
            when {
                target > nums[mid] -> min = mid + 1
                target < nums[mid] -> max = mid - 1
                else -> return mid
            }
            mid = (min/2.0 + max/2.0).toInt()
        }
        return -1
    }

    override val givenTestCases: Map<String, Int> = mapOf(
        "[-1,0,3,5,9,12] 9" to 4,
        "[-1,0,3,5,9,12] 2" to -1
    )

    override fun algorithm(input: Params): Int = search(input.nums, input.target)
    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        return Params(split[0].toIntArray(), split[1].toInt())
    }
    class Params(val nums: IntArray, val target: Int)
}