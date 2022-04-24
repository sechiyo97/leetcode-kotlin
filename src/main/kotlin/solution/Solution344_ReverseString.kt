package solution

import Solution

// must use same variable for input and output
class Solution344_ReverseString: Solution<CharArray, CharArray>(){
    override val givenTestCases: Map<String, CharArray> = mapOf(
        "hello" to "olleh".toCharArray(),
        "hannah" to "hannah".toCharArray()
    )

    override fun algorithm(params: CharArray): CharArray {
        var temp: Char
        val length = params.size
        for (i in 0 until length/2) {
            temp = params[i]
            params[i] = params[length-1-i]
            params[length-1-i] = temp
        }
        return params // no return value in actual problem
    }

    override fun inputToParamType(input: String): CharArray {
        return input.toCharArray()
    }
}
