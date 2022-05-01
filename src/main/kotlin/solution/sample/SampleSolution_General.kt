package solution.sample

import Solution

/** A sample solution that receives an integer value, and returns 10*value **/
class SampleSolution_General: Solution.General<Int, Int>() {
    fun sampleFunction(sampleParam: Int): Int {
        // leetcode solution
        return 10*sampleParam
    }

    override val givenTestCases: Map<String, Int> = mapOf(
        "1" to 10,
        "2" to 20,
        "33" to 330
    )
    override val customTestCases: Map<String, Int> = mapOf(
        "23134" to 231340,
        "121" to 1210
    )

    override fun algorithm(input: Int): Int = sampleFunction(input)
    override fun inputStringToInputType(input: String): Int {
        return Integer.valueOf(input)
    }
}