package solution.sample

import Solution

/**
 * A sample solution that receives an integer value n and a String value str,
 * and returns String with str repeated n times
 **/
class SampleSolution_General_MultipleParams: Solution.General<SampleSolution_General_MultipleParams.Params, String>() {
    class Params(val n: Int, val str: String)

    override val givenTestCases: Map<String, String> = mapOf(
        "1 a" to "a",
        "2 2" to "22",
        "3 s" to "sss"
    )
    override val customTestCases: Map<String, String> = mapOf(
        "3 c" to "ccc",
        "10 k" to "kkkkkkkkkk"
    )

    override fun algorithm(input: Params): String {
        // transform into input params of the actual answer sheet
        val n = input.n
        val str = input.str

        // from here can be pasted into the actual answer sheet
        return str.repeat(n)
    }

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        return Params(split[0].toInt(), split[1])
    }
}