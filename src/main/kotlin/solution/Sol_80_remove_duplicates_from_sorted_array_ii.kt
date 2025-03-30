package solution

import Solution
import common.toIntArray

// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
class Sol_80_remove_duplicates_from_sorted_array_ii: Solution.General<Sol_80_remove_duplicates_from_sorted_array_ii.Params, Int>() {
    /**
     * second solution
     */
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.size <= 2) return nums.size

        var i = 2
        for (j in 2 until nums.size) {
            if (nums[j] != nums[i-2]) {
                nums[i] = nums[j]
                i++
            }
        }
        return i
    }

    /**
     * first solution
     */
//    fun removeDuplicates(nums: IntArray): Int {
//        if (nums.isEmpty()) return 0
//        val hashMap = HashMap<Int, Int>()
//
//        var i = 0
//        hashMap[nums[i]] = 1
//
//        for (j in 1 until nums.size) {
//            if (nums[i] != nums[j] || (hashMap[nums[i]] ?: 0) < 2) {
//                i++
//                nums[i] = nums[j]
//                hashMap[nums[i]] = (hashMap[nums[i]] ?: 0) + 1
//            }
//        }
//        return i + 1
//    }

    override val givenTestCases: Map<String, Int> = mapOf(
        "[1,1,1,2,2,3]" to 5,
        "[0,0,1,1,1,1,2,3,3]" to 7
    )

    override val customTestCases: Map<String, Int> = mapOf(
    )

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        val nums = split[0].toIntArray()
        return Params(nums)
    }
    override fun algorithm(input: Params): Int= removeDuplicates(input.nums)
    class Params(val nums: IntArray)
}
