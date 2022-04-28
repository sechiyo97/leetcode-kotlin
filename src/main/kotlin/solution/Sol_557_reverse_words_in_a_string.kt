package solution

import Solution

class Sol_557_reverse_words_in_a_string: Solution.General<String, String>() {
    override val givenTestCases: Map<String, String> = mapOf(
        "Let's take LeetCode contest" to "s'teL ekat edoCteeL tsetnoc",
        "God Ding" to "doG gniD"
    )

    override fun algorithm(input: String): String {
        val s = input

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

    override fun inputStringToInputType(input: String): String {
        return input
    }

}

