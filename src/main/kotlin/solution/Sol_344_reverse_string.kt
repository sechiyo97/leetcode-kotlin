package solution

import Solution

// https://leetcode.com/problems/reverse-string/
class Sol_344_reverse_string: Solution.InPlaceArray<CharArray, CharArray>(){
    fun reverseString(s: CharArray): Unit {
        var temp: Char
        val length = s.size
        for (i in 0 until length/2) {
            temp = s[i]
            s[i] = s[length-1-i]
            s[length-1-i] = temp
        }
    }

    override val givenTestCases: Map<String, CharArray> = mapOf(
        "hello" to "olleh".toCharArray(),
        "hannah" to "hannah".toCharArray()
    )

    override fun algorithm(input: CharArray) = reverseString(input)
    override fun inputStringToInputType(input: String): CharArray {
        return input.toCharArray()
    }
    override fun getTargetArrayFromInput(input: CharArray): CharArray {
        return input
    }
}
