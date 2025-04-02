package solution

import Solution
import common.to2DIntArray

// https://leetcode.com/problems/merge-intervals/
class Sol_56_merge_intervals: Solution.General<Sol_56_merge_intervals.Params, Array<IntArray>>() {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.isEmpty()) return intervals

        val result = mutableListOf<IntArray>()
        intervals.sortBy { it[0] } // sort by first element

        var current = 0
        var compare = 0

        while(compare <= intervals.size) {
            if (compare == intervals.size || intervals[current][1] < intervals[compare][0]) {
                result.add(intervals[current])
                current = compare
            } else if (intervals[current][1] < intervals[compare][1]) {
                intervals[current][1] = intervals[compare][1]
            } else {
                // do nothing. compare target is inside current interval
            }
            compare++
        }

        return result.toTypedArray()
    }

    override val givenTestCases: Map<String, Array<IntArray>> = mapOf(
        "[[1,3],[2,6],[8,10],[15,18]]" to "[[1,6],[8,10],[15,18]]".to2DIntArray(),
        "[[1,4],[4,5]]" to "[[1,5]]".to2DIntArray(),
    )

    override val customTestCases: Map<String, Array<IntArray>> = mapOf(
        "[[1,4],[0,4]]" to "[[0,4]]".to2DIntArray(),
    )

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        val nums = split[0].to2DIntArray()
        return Params(nums)
    }
    override fun algorithm(input: Params): Array<IntArray> = merge(input.nums)
    class Params(val nums: Array<IntArray>)
}
