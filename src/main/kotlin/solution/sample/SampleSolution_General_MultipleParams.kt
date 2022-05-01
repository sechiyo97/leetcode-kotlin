package solution.sample

import Solution

/**
 * A sample solution that receives an integer value n and a String value str,
 * and returns String with str repeated n times
 **/
class SampleSolution_General_MultipleParams: Solution.General<SampleSolution_General_MultipleParams.Params, String>() {
    fun sampleFunction(sampleParam1: Int, sampleParam2: String): String {
        // leetcode solution
        return sampleParam2.repeat(sampleParam1)
    }

    override val givenTestCases: Map<String, String> = mapOf(
        "1 a" to "a",
        "2 2" to "22",
        "3 s" to "sss"
    )
    override val customTestCases: Map<String, String> = mapOf(
        "3 c" to "ccc",
        "10 k" to "kkkkkkkkkk"
    )

    override fun algorithm(input: Params): String = sampleFunction(input.sampleParam1, input.sampleParam2)
    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        return Params(split[0].toInt(), split[1])
    }
    class Params(val sampleParam1: Int, val sampleParam2: String)
}