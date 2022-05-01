package solution

import Solution

// https://leetcode.com/problems/reverse-words-in-a-string-iii/
class Sol_557_reverse_words_in_a_string_iii: Solution.General<String, String>() {
    fun reverseWords(s: String): String {
        val ssb = StringBuilder()
        var putIndex = 0
        for (i in s.indices) {
            if (s[i] == ' ') {
                putIndex = i
                ssb.insert(putIndex, s[i])
                putIndex++
            } else {
                ssb.insert(putIndex, s[i])
            }
        }
        return ssb.toString()
    }

    override val givenTestCases: Map<String, String> = mapOf(
        "Let's take LeetCode contest" to "s'teL ekat edoCteeL tsetnoc",
        "God Ding" to "doG gniD"
    )

    override fun algorithm(input: String): String = reverseWords(input)
    override fun inputStringToInputType(input: String): String {
        return input
    }
}

