package solution

class Sol_1641_count_sorted_vowel_strings: Solution.General<Int, Int>() {
    fun countVowelStrings(n: Int): Int {
        return (n+1)*(n+2)*(n+3)*(n+4)/24
    }

    override val givenTestCases: Map<String, Int> = mapOf(
        "1" to 5,
        "2" to 15,
        "33" to 66045
    )

    override fun inputStringToInputType(input: String): Int = input.toInt()
    override fun algorithm(input: Int): Int = countVowelStrings(input)
}