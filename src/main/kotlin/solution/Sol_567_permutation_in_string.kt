package solution

import Solution

class Sol_567_permutation_in_string: Solution.General<Sol_567_permutation_in_string.Params, Boolean>() {
    data class Params(val s1: String, val s2: String)
    override val givenTestCases: Map<String, Boolean> = mapOf(
        "ab eidbaooo" to true,
        "ab eidboaoo" to false
    )
    override val customTestCases: Map<String, Boolean> = mapOf(
        "adc dcda" to true,
        "ab a" to false
    )

    override fun algorithm(input: Params): Boolean {
        val s1 = input.s1
        val s2 = input.s2

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

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        return Params(split[0], split[1])
    }

}

