package solution.sample

import Solution
import common.toIntArray

/** A sample solution that swaps first and last values of an integer array **/
class SampleSolution_InPlaceArray: Solution.InPlaceArray<IntArray, IntArray>() {
    fun sampleFunction(sampleParam: IntArray) {
        // leetcode solution
        val lastIndex = sampleParam.lastIndex
        val temp = sampleParam[0]
        sampleParam[0] = sampleParam[lastIndex]
        sampleParam[lastIndex] = temp
    }

    override val givenTestCases: Map<String, IntArray> = mapOf(
        "[1,2,3]" to intArrayOf(3,2,1)
    )
    override val customTestCases: Map<String, IntArray> = mapOf(
        "[5,4,3,2,1]" to intArrayOf(1,4,3,2,5)
    )

    override fun algorithm(input: IntArray) = sampleFunction(input)
    override fun inputStringToInputType(input: String): IntArray {
        return input.toIntArray()
    }
    override fun getTargetArrayFromInput(input: IntArray): IntArray = input
}