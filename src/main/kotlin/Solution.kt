abstract class Solution<InputType, OutputType> {
    protected abstract val givenTestCases: Map<String, OutputType>

    protected abstract fun algorithm(params: InputType): OutputType

    protected abstract  fun inputToParamType(input: String): InputType

    fun runInputCase() {
        print("Your Input: ")
        val input = readLine()!!
        val params = inputToParamType(input)
        val result = algorithm(params)
        println("result is ${result.convertToString()}")
    }

    fun runGivenTestCases() {
        var passCases = 0
        val totalCases = givenTestCases.size
        givenTestCases.keys.forEachIndexed{ index, input ->
            println("case $index: $input")
            val params = inputToParamType(input)
            val result = algorithm(params)
            val expected = givenTestCases[input]
            if (result.checkContentEquals(expected)) {
                passCases++
                println("Pass")
            }
            else {
                val wasString = result?.convertToString()
                val expectedString = expected?.convertToString()
                println("Fail (was: $wasString, expected: $expectedString)")
            }
            println()
        }
        println("passed cases: $passCases/$totalCases")
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

    private fun OutputType.checkContentEquals(other: OutputType?): Boolean {
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
}