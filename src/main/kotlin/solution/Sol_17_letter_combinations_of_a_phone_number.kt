package solution

class Sol_17_letter_combinations_of_a_phone_number: Solution.General<String, List<String>>() {
    fun letterCombinations(digits: String): List<String> {
        val result = mutableListOf<String>()
        if (digits.isEmpty()) return result

        val availableCnt = if(digits[0] == '9' || digits[0] == '7') 4 else 3
        var first = 'a' + (digits[0] - '2')*3
        if (digits[0] > '7') first++
        val exceptStartLetter = letterCombinations(digits.substring(1))
        for (i in 0 until availableCnt) {
            val startLetter = first + i
            val withStartLetter =
                if (exceptStartLetter.isEmpty().not()) exceptStartLetter.map { startLetter + it }
                else listOf(startLetter.toString())
            result.addAll(withStartLetter)
        }
        return result
    }

    override val givenTestCases: Map<String, List<String>> = mapOf(
        "23" to listOf("ad","ae","af","bd","be","bf","cd","ce","cf"),
        "" to listOf(),
        "2" to listOf("a", "b", "c")
    )
    override val customTestCases: Map<String, List<String>> = mapOf(
        "7" to listOf("p","q","r","s")
    )
    override fun inputStringToInputType(input: String): String = input
    override fun algorithm(input: String): List<String> = letterCombinations(input)
}