package solution

import common.toIntArray

// https://leetcode.com/problems/subarray-product-less-than-k/
class Sol_713_subarray_product_less_than_k: Solution.General<Sol_713_subarray_product_less_than_k.Params, Int>() {
    fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
        if (k == 0 || k == 1) return 0

        var start = 0
        var end = 0
        var mul = 1
        var cnt = 0

        while (end < nums.size) {
            end++
            mul *= nums[end-1]
            while (mul >= k) {
                mul /= nums[start]
                start++
            }
            cnt += (end-start)
        }
        return cnt
    }

    override val givenTestCases: Map<String, Int> = mapOf(
        "[10,5,2,6] 100" to 8,
        "[1,2,3] 0" to 0
    )
    override val customTestCases: Map<String, Int> = mapOf(
        "[10,9,10,4,3,8,3,3,6,2,10,10,9,3] 19" to 18,
        "[5,5,5] 26" to 5
    )

    override fun algorithm(input: Params): Int = numSubarrayProductLessThanK(input.nums, input.k)
    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        val nums = split[0].toIntArray()
        val k = split[1].toInt()
        return Params(nums, k)
    }
    class Params(val nums: IntArray, val k: Int)
}