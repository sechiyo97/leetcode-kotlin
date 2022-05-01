package solution

import Solution

// https://leetcode.com/problems/permutation-in-string/
class Sol_567_permutation_in_string: Solution.General<Sol_567_permutation_in_string.Params, Boolean>() {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) return false

        val alphabets = IntArray(26)
        val checker = IntArray(26)

        s1.forEach { alphabets[it-'a']++ }

        var left = 0
        var right = 0

        while (right<s1.length) {
            checker[s2[right]-'a']++
            right++
        }

        while(right<s2.length+1) {
            var i = 0
            while(i<s1.length) {
                if(alphabets[s1[i]-'a'] != checker[s1[i]-'a']) break
                i++
            }
            if (i==s1.length) return true
            if (right == s2.length) return false

            checker[s2[left]-'a']--
            checker[s2[right]-'a']++
            left++
            right++
        }
        return false
    }

    override val givenTestCases: Map<String, Boolean> = mapOf(
        "ab eidbaooo" to true,
        "ab eidboaoo" to false
    )
    override val customTestCases: Map<String, Boolean> = mapOf(
        "adc dcda" to true,
        "ab a" to false
    )

    override fun algorithm(input: Params): Boolean = checkInclusion(input.s1, input.s2)
    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        return Params(split[0], split[1])
    }
    data class Params(val s1: String, val s2: String)
}

