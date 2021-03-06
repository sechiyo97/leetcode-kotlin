import common.checkContentEquals
import common.convertToString

// Todo: add kdoc
sealed class Solution<InputType, OutputType, GivenResultType> {
    // implementation required for actual solutions
    protected abstract val givenTestCases: Map<String, OutputType>
    protected open val customTestCases: Map<String, OutputType> = emptyMap()

    abstract fun algorithm(input: InputType): GivenResultType
    abstract fun inputStringToInputType(input: String): InputType

    // open methods
    fun testWithGivenCases() {
        println("====== run given test cases ======")
        runTestsForCases(givenTestCases)
    }
    fun testWithCustomCases() {
        println("====== run custom test cases =====")
        runTestsForCases(customTestCases)
    }

    fun runWithInputCase() {
        println("==== get result of input case ====")
        print("your input: ")
        val inputString = readLine()!!
        val result = getResultForInputString(inputString)
        println("result: ${result.convertToString()}")
    }

    // implementation required for classes that override Solution class
    abstract fun getResultForInputString(inputString: String): OutputType
    abstract fun checkTestCaseSuccess(inputString: String, expected: OutputType?): TestResult<OutputType>

    open fun checkEquals(result: OutputType, expected: OutputType?) = result.checkContentEquals(expected)

    // no need to implement
    private fun runTestsForCases(testCases: Map<String, OutputType>) {
        var passCases = 0
        val totalCases = testCases.size
        testCases.keys.forEachIndexed { index, input ->
            print("case $index: ")
            try {
                val expected = testCases[input]
                when (val result = checkTestCaseSuccess(input, expected)) {
                    is TestResult.Success -> {
                        passCases++
                        val resultString = result.result.convertToString()
                        println("pass (input: $input, result: $resultString)")
                    }
                    is TestResult.Fail -> {
                        val resultString = result.result.convertToString()
                        val expectedString = result.expected.convertToString()
                        println("fail (input: $input, result: $resultString, expected: $expectedString)")
                    }
                }
            } catch (e: Exception) {
                println("\nexception in case: $input")
                throw e
            }
        }
        println("passed cases: $passCases/$totalCases")
    }

    sealed class TestResult<OutputType> {
        class Success<Type>(val result: Type?): TestResult<Type>()
        class Fail<Type>(val result: Type?, val expected: Type?): TestResult<Type>()
    }

    abstract class General<InputType, OutputType>: Solution<InputType, OutputType, OutputType>() {
        override fun getResultForInputString(inputString: String): OutputType {
            val input = inputStringToInputType(inputString)
            return algorithm(input)
        }

        override fun checkTestCaseSuccess(inputString: String, expected: OutputType?): TestResult<OutputType> {
            val input = inputStringToInputType(inputString)
            val result = algorithm(input)
            val pass = checkEquals(result, expected)
            return if (pass) TestResult.Success(result) else TestResult.Fail(result, expected)
        }
    }

    abstract class InPlaceArray<InputType, TargetArrayType> : Solution<InputType, TargetArrayType, Unit>() {
        abstract fun getTargetArrayFromInput(input: InputType): TargetArrayType

        override fun getResultForInputString(inputString: String): TargetArrayType {
            val input = inputStringToInputType(inputString)
            algorithm(input)
            return getTargetArrayFromInput(input)
        }

        override fun checkTestCaseSuccess(inputString: String, expected: TargetArrayType?): TestResult<TargetArrayType> {
            val input = inputStringToInputType(inputString)
            algorithm(input)
            val result = getTargetArrayFromInput(input)
            val pass = checkEquals(result, expected)
            return if (pass) TestResult.Success(result) else TestResult.Fail(result, expected)
        }
    }
}
