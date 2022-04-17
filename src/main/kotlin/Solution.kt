abstract class Solution<InputType, OutputType> {
    protected abstract val givenTestCases: Map<String, OutputType>

    protected abstract fun algorithm(params: InputType): OutputType

    protected abstract  fun inputToParamType(input: String): InputType

    fun runInputCase() {
        print("Your Input: ")
        val input = readLine()!!
        val params = inputToParamType(input)
        val result = algorithm(params)
        println("result is $result")
    }

    fun runGivenTestCases() {
        var passCases = 0
        val totalCases = givenTestCases.size
        givenTestCases.keys.forEachIndexed{ index, input ->
            println("case $index: $input")
            val params = inputToParamType(input)
            val result = algorithm(params)
            if (result == givenTestCases[input]) {
                passCases++
                println("Pass")
            }
            else
                println("Fail (was: $result, expected: ${givenTestCases[input]})")
            println()
        }
        println("passed cases: $passCases/$totalCases")
    }
}