package solution

import Solution
import common.toIntArray
import common.toStringArray

// https://leetcode.com/problems/summary-ranges/
class Sol_228_summary_ranges: Solution.General<Sol_228_summary_ranges.Params, List<String>>() {
    fun summaryRanges(nums: IntArray): List<String> {
        val result = mutableListOf<String>()
        var i = 0
        var j = 1

        while (j <= nums.size) {
            if (j == nums.size || nums[j] != nums[j-1] + 1) {
                if (i == j-1) result.add(nums[i].toString())
                else result.add("${nums[i]}->${nums[j-1]}")
                i = j
            }
            j++
        }

        return result
    }

    override val givenTestCases: Map<String, List<String>> = mapOf(
        "[0,1,2,4,5,7]" to "[\"0->2\",\"4->5\",\"7\"]".toStringArray().toList(),
        "[0,2,3,4,6,8,9]" to "[\"0\",\"2->4\",\"6\",\"8->9\"]".toStringArray().toList()
    )

    override val customTestCases: Map<String, List<String>> = mapOf(
    )

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        val nums = split[0].toIntArray()
        return Params(nums)
    }
    override fun algorithm(input: Params): List<String> = summaryRanges(input.nums)
    class Params(val nums: IntArray)
}
