package solution

// https://leetcode.com/problems/find-all-anagrams-in-a-string/
class Sol_438_find_all_anagrams_in_a_string: Solution.General<Sol_438_find_all_anagrams_in_a_string.Params, List<Int>>() {
    fun findAnagrams(s: String, p: String): List<Int> {
        if (p.length > s.length) return listOf()

        val result = mutableListOf<Int>()
        var covered = 0

        // init
        val letters = IntArray(26)
        p.forEach { letters[it-'a']++ }

        // create window
        var start = 0
        var end = 0
        for(i in p.indices) {
            letters[s[end]-'a']--
            if(letters[s[end]-'a'] >= 0) covered++
            end++
        }
        if (covered == p.length) result.add(start)

        // move window
        while (end < s.length) {

            letters[s[start]-'a']++
            if(letters[s[start]-'a'] > 0) covered--

            letters[s[end]-'a']--
            if(letters[s[end]-'a'] >= 0) covered++

            start++
            end++
            if (covered == p.length) result.add(start)
        }

        return result
    }

    override val givenTestCases: Map<String, List<Int>> = mapOf(
        "cbaebabacd abc" to listOf(0,6),
        "abab ab" to listOf(0,1,2),
    )

    override val customTestCases: Map<String, List<Int>> = mapOf(
        "abacbabc abc" to listOf(1,2,3,5)
    )
    
    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        return Params(split[0], split[1])
    }
    override fun algorithm(input: Params): List<Int> = findAnagrams(input.s, input.p)
    class Params(val s: String, val p: String)
}