/** A sample solution that receives an integer value, and returns 10*value **/
class SampleSolution: Solution<Int, Int>() {
    override val givenTestCases: Map<String, Int> = mapOf(
        "1" to 10,
        "2" to 20,
        "33" to 330
    )

    override fun algorithm(params: Int): Int {
        return 10*params
    }

    override fun inputToParamType(input: String): Int {
        return Integer.valueOf(input)
    }
}