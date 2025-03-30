package solution

import Solution
import common.toStringArray
import kotlin.math.min

// https://leetcode.com/problems/word-break/
class Sol_139_word_break :
    Solution.General<Sol_139_word_break.Params, Boolean>() {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val memo = hashMapOf<String, Boolean>()
        wordDict.forEach {
            memo[it] = true
        }
        return wordBreakInternal(s, memo)
    }

    private fun wordBreakInternal(remaining: String, memo: MutableMap<String, Boolean>): Boolean {
        if (remaining.isBlank()) return true
        if (memo[remaining] != null) return memo[remaining]!!

        for (i in 1.. remaining.length) {
            val piece = remaining.substring(0, i)
            if (memo[piece] == true) {
                val nextRemaining = remaining.substring(i)
                val success = wordBreakInternal(nextRemaining, memo)
                if (success) {
                    memo[remaining] = true
                    return true
                }
            }
        }
        memo[remaining] = false
        return false
    }

    override val givenTestCases: Map<String, Boolean> = mapOf(
        "leetcode [\"leet\",\"code\"]" to true,
        "applepenapple [\"apple\",\"pen\"]" to true,
        "catsandog [\"cats\",\"dog\",\"sand\",\"and\",\"cat\"]" to false,
    )

    override val customTestCases: Map<String, Boolean> = mapOf(
        "aaaaaaa [\"aaaa\",\"aaa\"]" to true,
        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab [\"a\",\"aa\",\"aaa\",\"aaaa\",\"aaaaa\",\"aaaaaa\",\"aaaaaaa\",\"aaaaaaaa\",\"aaaaaaaaa\",\"aaaaaaaaaa\"]" to false
    )

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        val s = split[0]
        val wordDict = split[1].toStringArray().toList()
        return Params(s, wordDict)
    }

    override fun algorithm(input: Params): Boolean = wordBreak(input.s, input.wordDict)
    class Params(val s: String, val wordDict: List<String>)
}
