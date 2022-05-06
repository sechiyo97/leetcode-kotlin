package solution

import Solution
import common.to2DIntArray

// https://leetcode.com/problems/interval-list-intersections/
class Sol_986_interval_list_intersections: Solution.General<Sol_986_interval_list_intersections.Params, Array<IntArray>>() {
    fun intervalIntersection(firstList: Array<IntArray>, secondList: Array<IntArray>): Array<IntArray> {
        val result = mutableListOf<IntArray>()
        var i = 0
        var j = 0
        while(i < firstList.size && j < secondList.size) {
            // add intersection
            val startTime = firstList[i][0].coerceAtLeast(secondList[j][0])
            val endTime = firstList[i][1].coerceAtMost(secondList[j][1])
            if (endTime >= startTime) result.add(intArrayOf(startTime, endTime))

            // next
            val nextStartTime1 = if (i < firstList.size-1) firstList[i+1][0] else null
            val nextStartTime2 = if (j < secondList.size-1) secondList[j+1][0] else null
            when {
                nextStartTime1 == null -> j++
                nextStartTime2 == null -> i++
                nextStartTime1 > nextStartTime2 -> j++
                else -> i++
            }
        }
        return result.toTypedArray()
    }

    override val givenTestCases: Map<String, Array<IntArray>> = mapOf(
        "[[0,2],[5,10],[13,23],[24,25]] [[1,5],[8,12],[15,24],[25,26]]" to "[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]".to2DIntArray(),
        "[[1,3],[5,9]] []" to "[]".to2DIntArray()
    )

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        val firstList = split[0].to2DIntArray()
        val secondList = split[1].to2DIntArray()
        return Params(firstList, secondList)
    }
    override fun algorithm(input: Params): Array<IntArray> = intervalIntersection(input.firstList, input.secondList)
    class Params(val firstList: Array<IntArray>, val secondList: Array<IntArray>)
}