package solution

// https://leetcode.com/problems/letter-case-permutation/
class Sol_784_letter_case_permutation: Solution.General<String, List<String>>() {
    fun letterCasePermutation(s: String): List<String> {
        if (s.isEmpty()) return listOf("")

        val subString = s.substring(1)
        if (s[0].isLetter().not()) return letterCasePermutation(subString).map { s[0] + it }

        val lower = s[0].toLower()
        val upper = s[0].toUpper()

        val lowerResult = letterCasePermutation(subString).map { lower + it }
        val upperResult = letterCasePermutation(subString).map { upper + it }

        val result = mutableListOf<String>().apply {
            addAll(lowerResult)
            addAll(upperResult)
        }

        return result
    }

    private fun Char.toLower(): Char {
        return if (this in 'A'..'Z') this-('A'-'a')
        else this
    }

    private fun Char.toUpper(): Char {
        return if (this in 'a'..'z') this+('A'-'a')
        else this
    }

    override val givenTestCases: Map<String, List<String>> = mapOf(
        "a1b2" to listOf("a1b2", "a1B2", "A1b2", "A1B2"),
        "3z4" to listOf("3z4","3Z4")
    )

    override fun algorithm(input: String): List<String> = letterCasePermutation(input)
    override fun inputStringToInputType(input: String): String {
        return input
    }

    override fun checkEquals(result: List<String>, expected: List<String>?): Boolean {
        return result.toSet() == expected?.toSet()
    }
}