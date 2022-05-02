package solution

import common.toIntArray

// https://leetcode.com/problems/house-robber/
class Sol_198_house_robber: Solution.General<IntArray, Int>() {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        var result1 = nums[0]
        var result2 = if (nums[0] > nums[1]) nums[0] else nums[1]
        var temp: Int
        for (i in 2 until nums.size) {
            val compare1 = result2
            val compare2 = result1 + nums[i]
            temp = result2
            result2 = if (compare1 > compare2) compare1 else compare2
            result1 = temp
        }
        return result2
    }

    override val givenTestCases: Map<String, Int> = mapOf(
        "[1,2,3,1]" to 4,
        "[2,7,9,3,1]" to 12
    )

    override fun inputStringToInputType(input: String): IntArray = input.toIntArray()
    override fun algorithm(input: IntArray): Int = rob(input)
}