package solution.sample

import Solution
import common.toIntArray

/** A sample solution that adds an integer value to each element of an integer array **/
class SampleSolution_InPlaceArray_MultipleParams: Solution.InPlaceArray<SampleSolution_InPlaceArray_MultipleParams.Params, IntArray>() {
    fun sampleFunction(sampleParam1: IntArray, sampleParam2: Int) {
        // leetcode solution
        sampleParam1.indices.forEach{
            sampleParam1[it] += sampleParam2
        }
    }
    override val givenTestCases: Map<String, IntArray> = mapOf(
        "[1,2,3] 2" to intArrayOf(3,4,5)
    )
    override val customTestCases: Map<String, IntArray> = mapOf(
        "[10,20,30] 3" to intArrayOf(13,23,33)
    )

    override fun algorithm(input: Params) = sampleFunction(input.sampleParam1, input.sampleParam2)
    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        val nums = split[0].toIntArray()
        val add = split[1].toInt()
        return Params(nums, add)
    }
    override fun getTargetArrayFromInput(input: Params): IntArray {
        return input.sampleParam1
    }
    class Params(val sampleParam1: IntArray, val sampleParam2: Int)
}