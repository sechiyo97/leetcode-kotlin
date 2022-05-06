package solution

import Solution
import common.toIntArray

// https://leetcode.com/problems/container-with-most-water/
class Sol_11_container_with_most_water: Solution.General<IntArray, Int>() {
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size-1

        var maxArea = 0
        while (left<right) {
            val area = (right-left) * height[right].coerceAtMost(height[left])
            if (area > maxArea) maxArea = area
            if (height[left] > height[right]) {
                val curRight = height[right]
                while (left < right && curRight >= height[right]) right--
            }
            else {
                val curLeft = height[left]
                while (left < right && curLeft >= height[left]) left++
            }
        }
        return maxArea
    }

    override val givenTestCases: Map<String, Int> = mapOf(
        "[1,8,6,2,5,4,8,3,7]" to 49,
        "[1,1]" to 1
    )
    override val customTestCases: Map<String, Int> = mapOf(
        "[1,2,4,3]" to 4
    )

    override fun inputStringToInputType(input: String): IntArray = input.toIntArray()
    override fun algorithm(input: IntArray): Int  = maxArea(input)
}