package solution

import Solution

// must use same variable for input and output
class Solution344_ReverseString: Solution<CharArray, CharArray>(){
    override val givenTestCases: Map<String, CharArray> = mapOf(
        "hello" to "olleh".toCharArray(),
        "hannah" to "hannah".toCharArray()
    )

    override fun algorithm(params: CharArray): CharArray {
        return params
    }

    override fun inputToParamType(input: String): CharArray {
        return input.toCharArray()
    }
}
