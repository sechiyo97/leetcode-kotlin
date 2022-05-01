package solution

import common.toIntArray

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
class Sol_167_two_sum_ii_input_array_is_sorted: Solution.General<Sol_167_two_sum_ii_input_array_is_sorted.Params, IntArray>(){
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var left = 0
        var right = numbers.lastIndex
        while(numbers[left]+numbers[right] != target) {
            if (numbers[left]+numbers[right] > target) right--
            else left++
        }

        return intArrayOf(left+1, right+1)
    }

    override val givenTestCases: Map<String, IntArray> = mapOf(
        "[2,7,11,15] 9" to intArrayOf(1,2),
        "[2,3,4] 6" to intArrayOf(1,3),
        "[-1,0] -1" to intArrayOf(1,2)
    )

    override fun algorithm(input: Params): IntArray = twoSum(input.numbers, input.target)
    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        return Params(split[0].toIntArray(), split[1].toInt())
    }
    class Params(val numbers: IntArray, val target: Int)
}


