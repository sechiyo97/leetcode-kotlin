package solution

import Solution

class Sol_344_reverse_string: Solution.InPlaceArray<CharArray, CharArray>(){
    override val givenTestCases: Map<String, CharArray> = mapOf(
        "hello" to "olleh".toCharArray(),
        "hannah" to "hannah".toCharArray()
    )

    override fun algorithm(input: CharArray) {
        var temp: Char
        val length = input.size
        for (i in 0 until length/2) {
            temp = input[i]
            input[i] = input[length-1-i]
            input[length-1-i] = temp
        }
    }

    override fun inputStringToInputType(input: String): CharArray {
        return input.toCharArray()
    }

    override fun inputTypeToArrayType(input: CharArray): CharArray {
        return input
    }
}
