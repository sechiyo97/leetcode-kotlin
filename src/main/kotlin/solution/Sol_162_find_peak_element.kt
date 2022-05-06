package solution

import Solution
import common.toIntArray
import kotlin.math.log10

class Sol_162_find_peak_element: Solution.General<IntArray, Int>() {
    fun findPeakElement(nums: IntArray): Int {
        if (nums.size == 1) return 0

        var left = 0
        var right = nums.size-1
        var mid = -1
        while(left<=right) {
            mid = (left+right)/2
            val toRight = when {
                mid == 0 -> if (nums[0] > nums[1]) return 0 else true
                mid == nums.size-1 -> if (nums[mid] > nums[mid-1]) return mid else false
                nums[mid-1] < nums[mid] && nums[mid+1] < nums[mid] -> return mid
                nums[mid-1] < nums[mid] -> true
                else -> false
            }
            if (toRight) left = mid+1
            else right = mid-1
        }
        return mid
    }

    override val givenTestCases: Map<String, Int> = mapOf(
        "[1,2,3,1]" to 2*1,
        "[1,2,1,3,5,6,4]" to 2*1000+5*1,

        "[1,2]" to 1
    )

    override fun inputStringToInputType(input: String): IntArray = input.toIntArray()
    override fun algorithm(input: IntArray): Int = findPeakElement(input)
    override fun checkEquals(result: Int, expected: Int?): Boolean {
        if (expected == null) return false
        var value = expected
        var availableResults = IntArray(log10(expected.toDouble()).toInt()/3 + 1) {
            val left = value%1000
            value/=1000
            left
        }
        return availableResults.contains(result)
    }
}