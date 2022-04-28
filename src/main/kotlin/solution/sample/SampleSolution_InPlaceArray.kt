package solution.sample

import Solution
import common.toIntArray

/** A sample solution that swaps first and last values of an integer array **/
class SampleSolution_InPlaceArray: Solution.InPlaceArray<IntArray, IntArray>() {
    override val givenTestCases: Map<String, IntArray> = mapOf(
        "[1,2,3]" to intArrayOf(3,2,1)
    )
    override val customTestCases: Map<String, IntArray> = mapOf(
        "[5,4,3,2,1]" to intArrayOf(1,4,3,2,5)
    )

    override fun algorithm(input: IntArray) {
        // transform into input params of the actual answer sheet
        val nums = input

        // from here can be pasted into the actual answer sheet
        val lastIndex = input.lastIndex
        val temp = input[0]
        input[0] = input[lastIndex]
        input[lastIndex] = temp
    }

    override fun inputStringToInputType(input: String): IntArray {
        return input.toIntArray()
    }

    override fun getTargetArrayFromInput(input: IntArray): IntArray = input
}