package solution

import common.toIntArray

class Sol_35_search_insert_position: Solution.General<Sol_35_search_insert_position.Params, Int>(){
    class Params(val nums: IntArray, val target: Int)

    override val givenTestCases: Map<String, Int> = mapOf(
        "[1,3,5,6] 5" to 2,
        "[1,3,5,6] 2" to 1,
        "[1,3,5,6] 7" to 4
    )

    override fun algorithm(input: Params): Int {
        val nums = input.nums
        val target = input.target

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

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        return Params(split[0].toIntArray(), split[1].toInt())
    }

}

