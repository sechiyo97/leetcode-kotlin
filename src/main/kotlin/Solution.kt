abstract class Solution<InputType, OutputType> {
    protected abstract val givenTestCases: Map<String, OutputType>
    protected open val customTestCases: Map<String, OutputType> = emptyMap()

    protected abstract fun algorithm(params: InputType): OutputType

    protected abstract  fun inputToParamType(input: String): InputType

    fun runWithInputCase() {
        print("Your Input: ")
        val input = readLine()!!
        val params = inputToParamType(input)
        val result = algorithm(params)
        println("result is ${result.convertToString()}")
    }

    fun testWithGivenCases() = runTestsForCases(givenTestCases)
    fun testWithCustomCases() = runTestsForCases(customTestCases)

    fun runTestsForCases(testCases: Map<String, OutputType>) {
        var passCases = 0
        val totalCases = testCases.size
        testCases.keys.forEachIndexed{ index, input ->
            println("case $index: $input")
            val expected = testCases[input]!!
            when (val result = checkTestSuccess(input, expected)) {
                is TestResult.Success -> {
                    passCases++
                    println("Pass")
                }
                is TestResult.Fail -> {
                    val wasString = result.was.convertToString()
                    val expectedString = result.expected.convertToString()
                    println("Fail (was: $wasString, expected: $expectedString)")
                }
            }
            println()
        }
        println("passed cases: $passCases/$totalCases")
    }

    private fun checkTestSuccess(input: String, expected: OutputType): TestResult<OutputType> {
        val params = inputToParamType(input)
        val was = algorithm(params)
        val pass = was.checkContentEquals(expected)
        return if (pass) TestResult.Success() else TestResult.Fail(was, expected)
    }

    private fun OutputType.convertToString(): String {
        return when(this) {
            is IntArray -> this.contentToString()
            is BooleanArray -> this.contentToString()
            is FloatArray -> this.contentToString()
            is DoubleArray -> this.contentToString()
            is ByteArray -> this.contentToString()
            is CharArray -> this.contentToString()
            is LongArray -> this.contentToString()
            is ShortArray -> this.contentToString()
            is Array<*> -> this.contentToString()
            else -> this.toString()
        }
    }

    private fun OutputType.checkContentEquals(other: OutputType): Boolean {
        return when(this) {
            is IntArray -> this.contentEquals(other as IntArray)
            is BooleanArray -> this.contentEquals(other as BooleanArray)
            is FloatArray -> this.contentEquals(other as FloatArray)
            is DoubleArray -> this.contentEquals(other as DoubleArray)
            is ByteArray -> this.contentEquals(other as ByteArray)
            is CharArray -> this.contentEquals(other as CharArray)
            is LongArray -> this.contentEquals(other as LongArray)
            is ShortArray -> this.contentEquals(other as ShortArray)
            is Array<*> -> this.contentEquals(other as Array<*>)
            else -> this == other
        }
    }

    sealed class TestResult<OutputType> {
        class Success<Type>: TestResult<Type>()
        class Fail<Type>(val was: Type, val expected: Type): TestResult<Type>()
    }
}
