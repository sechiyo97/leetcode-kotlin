/**
 * A sample solution that receives an integer value n and a String value str,
 * and returns String with str repeated n times
 **/
class SampleSolutionWithMultipleParams: Solution<SampleSolutionWithMultipleParams.Params, String>() {
    class Params(val n: Int, val str: String)

    override val givenTestCases: Map<String, String> = mapOf(
        "1 a" to "a",
        "2 2" to "22",
        "3 s" to "sss"
    )

    override fun algorithm(params: Params): String {
        val n = params.n
        val str = params.str
        return str.repeat(n)
    }

    override fun inputToParamType(input: String): Params {
        val split = input.split(" ")
        return Params(split[0].toInt(), split[1])
    }
}