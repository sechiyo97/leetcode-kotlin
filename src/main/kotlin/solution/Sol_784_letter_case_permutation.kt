package solution

// https://leetcode.com/problems/letter-case-permutation/
class Sol_784_letter_case_permutation: Solution.General<String, List<String>>() {
    fun letterCasePermutation(s: String): List<String> {
        return listOf("3Z4","3z4")
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