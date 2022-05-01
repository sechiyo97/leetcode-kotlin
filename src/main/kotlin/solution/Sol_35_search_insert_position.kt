package solution

import common.toIntArray

// https://leetcode.com/problems/search-insert-position/
class Sol_35_search_insert_position: Solution.General<Sol_35_search_insert_position.Params, Int>(){
    fun searchInsert(nums: IntArray, target: Int): Int {
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

        return max+1
    }

    override val givenTestCases: Map<String, Int> = mapOf(
        "[1,3,5,6] 5" to 2,
        "[1,3,5,6] 2" to 1,
        "[1,3,5,6] 7" to 4
    )

    override fun algorithm(input: Params): Int = searchInsert(input.nums, input.target)
    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        return Params(split[0].toIntArray(), split[1].toInt())
    }
    class Params(val nums: IntArray, val target: Int)
}


