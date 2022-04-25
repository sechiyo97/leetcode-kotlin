package solution.sample

import Solution
import common.toIntArray

/** A sample solution that adds an integer value to each element of an integer array **/
class SampleSolution_InPlaceArray_MultipleParams: Solution.InPlaceArray<SampleSolution_InPlaceArray_MultipleParams.Params, IntArray>() {
    class Params(val nums: IntArray, val add: Int)

    override val givenTestCases: Map<String, IntArray> = mapOf(
        "[1,2,3] 2" to intArrayOf(3,4,5)
    )
    override val customTestCases: Map<String, IntArray> = mapOf(
        "[10,20,30] 3" to intArrayOf(13,23,33)
    )

    override fun algorithm(input: Params) {
        // transform into input params of the actual answer sheet
        val nums = input.nums
        val add = input.add

        // from here can be pasted into the actual answer sheet
        nums.indices.forEach{
            nums[it] += add
        }
    }

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        val nums = split[0].toIntArray()
        val add = split[1].toInt()
        return Params(nums, add)
    }

    override fun inputTypeToArrayType(input: Params): IntArray {
        return input.nums
    }
}