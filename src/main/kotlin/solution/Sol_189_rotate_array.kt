package solution

import Solution
import common.toIntArray

// https://leetcode.com/problems/rotate-array/
class Sol_189_rotate_array: Solution.InPlaceArray<Sol_189_rotate_array.Params, IntArray>(){
    /**
     * Algorithm #2: use characteristics of array rotation - sub-order remains
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    fun rotate(nums: IntArray, k: Int): Unit {
        val n = nums.size
        for (i in 0 until (n-k%n)/2) nums.swap(i, (n-1)-k%n-i)
        for (i in 0 until k%n/2) nums.swap((n-k%n)+i, (n-1)-i)
        for (i in 0 until n/2) nums.swap(i, (n-1)-i)
    }

    fun IntArray.swap(first: Int, second: Int) {
        val temp = this[first]
        this[first] = this[second]
        this[second] = temp
    }

    /**
     * Algorithm #1: create a new IntArray and put rotated values
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
//    fun algorithm2(nums: IntArray, k: Int): Unit {
//        val n = nums.size
//        val newArray = IntArray(n)
//        for (i in 0 until n) newArray[(i+k)%n] = nums[i]
//        for (i in 0 until n) nums[i] = newArray[i]
//    }

    override val givenTestCases: Map<String, IntArray> = mapOf(
        "[1,2,3,4,5,6,7] 3" to intArrayOf(5,6,7,1,2,3,4),
        "[-1,-100,3,99] 2" to intArrayOf(3,99,-1,-100)
    )
    override val customTestCases: Map<String, IntArray> = mapOf(
        "[-1] 2" to intArrayOf(-1),
        "[-1,-2] 23" to intArrayOf(-2,-1)
    )

    override fun algorithm(input: Params) = rotate(input.nums, input.k)
    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        val nums = split[0].toIntArray()
        val k = split[1].toInt()
        return Params(nums, k)
    }
    override fun getTargetArrayFromInput(input: Params): IntArray {
        return input.nums
    }
    class Params(val nums: IntArray, val k: Int)
}
