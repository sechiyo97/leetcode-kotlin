package solution

import Solution
import common.swap
import common.toIntArray

class `Sol_189_rotate-array`: Solution.InPlaceArray<`Sol_189_rotate-array`.Params, IntArray>(){
    class Params(val nums: IntArray, val k: Int)

    override val givenTestCases: Map<String, IntArray> = mapOf(
        "[1,2,3,4,5,6,7] 3" to intArrayOf(5,6,7,1,2,3,4),
        "[-1,-100,3,99] 2" to intArrayOf(3,99,-1,-100)
    )
    override val customTestCases: Map<String, IntArray> = mapOf(
        "[-1] 2" to intArrayOf(-1),
        "[-1,-2] 23" to intArrayOf(-2,-1)
    )

    /**
     * Algorithm #1: create a new IntArray and put rotated values
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
//    override fun algorithm(params: Params) {
//        val nums = params.nums
//        val k = params.k
//
//        val n = nums.size
//        val newArray = IntArray(n)
//        for (i in 0 until n) newArray[(i+k)%n] = nums[i]
//        for (i in 0 until n) nums[i] = newArray[i]
//    }

    /**
     * Algorithm #2: use characteristics of array rotation - sub-order remains
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    override fun algorithm(input: Params) {
        val nums = input.nums
        val k = input.k

        val n = nums.size
        val simpleK = k%n
        for (i in 0 until (n-simpleK)/2) nums.swap(i, (n-1)-simpleK-i)
        for (i in 0 until simpleK/2) nums.swap((n-simpleK)+i, (n-1)-i)
        for (i in 0 until n/2) nums.swap(i, (n-1)-i)
    }

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        val nums = split[0].toIntArray()
        val k = split[1].toInt()
        return Params(nums, k)
    }

    override fun inputTypeToArrayType(input: Params): IntArray {
        return input.nums
    }
}
