package solution

import Solution
import common.toIntArray

// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
class Sol_88_merge_sorted_array: Solution.General<Sol_88_merge_sorted_array.Params, IntArray>() {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): IntArray {
        var i = m-1
        var j = n-1
        var currentIdx = m+n-1
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[currentIdx] = nums1[i]
                i--
            } else {
                nums1[currentIdx] = nums2[j]
                j--
            }
            currentIdx--
        }
        return nums1
    }

    override val givenTestCases: Map<String, IntArray> = mapOf(
        "[1,2,3,0,0,0] 3 [2,5,6] 3" to "[1,2,2,3,5,6]".toIntArray(),
        "[1] 1 [] 0" to "[1]".toIntArray(),
        "[0] 0 [1] 1" to "[1]".toIntArray()
    )

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        val nums1 = split[0].toIntArray()
        val m = split[1].toInt()
        val nums2 = split[2].toIntArray()
        val n = split[3].toInt()
        return Params(nums1, m, nums2, n)
    }
    override fun algorithm(input: Params): IntArray = merge(input.nums1, input.m, input.nums2, input.n)
    class Params(val nums1: IntArray, val m: Int, val nums2: IntArray, val n: Int)

}