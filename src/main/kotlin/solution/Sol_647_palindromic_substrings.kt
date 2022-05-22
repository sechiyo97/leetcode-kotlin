package solution

class Sol_647_palindromic_substrings: Solution.General<String, Int>() {
    fun countSubstrings(s: String): Int {
        var count = 0
        for (i in 0 until (2*s.length-1)) {
            val start = i/2
            val add = i%2
            var j = 0
            while (start-j >= 0 && start+add+j < s.length) {
                if (s[start+add+j] == s[start-j]) count++
                else break
                j++
            }
        }
        return count
    }

    override val givenTestCases: Map<String, Int> = mapOf(
        "abc" to 3,
        "aaa" to 6
    )

    override fun inputStringToInputType(input: String): String = input
    override fun algorithm(input: String): Int = countSubstrings(input)
}