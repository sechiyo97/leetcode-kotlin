package solution

import Solution
import common.toIntArray


// https://leetcode.com/problems/two-sum/
class Sol_1_two_sum: Solution.General<Sol_1_two_sum.Params, IntArray>() {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()
        val result = IntArray(2)
        for (i in nums.indices) {
            val x = target - nums[i]
            if (map.containsKey(x)) {
                result[0] = i
                result[1] = map[x]!!
                break
            } else {
                map[nums[i]] = i
            }
        }
        return result
    }

    override val givenTestCases: Map<String, IntArray> = mapOf(
        "[2,7,11,15] 9" to intArrayOf(0,1),
        "[3,2,4] 6" to intArrayOf(1,2),
        "[3,3] 6" to intArrayOf(0,1)
    )

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        val nums = split[0].toIntArray()
        val target = split[1].toInt()
        return Params(nums, target)
    }
    override fun algorithm(input: Params): IntArray = twoSum(input.nums, input.target)
    class Params(val nums: IntArray, val target: Int)

    override fun checkEquals(result: IntArray, expected: IntArray?): Boolean {
        return result.sorted() == expected?.sorted()
    }
}