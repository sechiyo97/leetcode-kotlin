package solution.sample

import Solution

/** A sample solution that receives an integer value, and returns 10*value **/
class SampleSolution_General: Solution.General<Int, Int>() {
    override val givenTestCases: Map<String, Int> = mapOf(
        "1" to 10,
        "2" to 20,
        "33" to 330
    )
    override val customTestCases: Map<String, Int> = mapOf(
        "23134" to 231340,
        "121" to 1210
    )

    override fun algorithm(params: Int): Int {
        // transform into input params of the actual answer sheet
        val num = params

        // from here can be pasted into the actual answer sheet
        return 10*params
    }

    override fun inputStringToInputType(input: String): Int {
        return Integer.valueOf(input)
    }
}