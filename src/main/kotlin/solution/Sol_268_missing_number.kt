package solution

import Solution
import common.toIntArray

class Sol_268_missing_number: Solution.General<IntArray, Int>() {
    fun missingNumber(nums: IntArray): Int {
        val result = BooleanArray(nums.size+1)
        nums.forEach {
            result[it] = true
        }
        result.forEachIndexed { index, value ->
            if (value.not()) return index
        }
        return -1
    }

    override val givenTestCases: Map<String, Int> = mapOf(
        "[3,0,1]" to 2,
        "[0,1]" to 2,
        "[9,6,4,2,3,5,7,0,1]" to 8
    )
    override fun inputStringToInputType(input: String): IntArray = input.toIntArray()
    override fun algorithm(input: IntArray): Int = missingNumber(input)
}