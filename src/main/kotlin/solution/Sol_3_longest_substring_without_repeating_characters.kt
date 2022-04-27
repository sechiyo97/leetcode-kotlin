package solution

class Sol_3_longest_substring_without_repeating_characters : Solution.General<String, Int>() {
    override val givenTestCases = mapOf(
        "abcabcbb" to 3,
        "bbbbb" to 1,
        "pwwkew" to 3
    )
    override val customTestCases: Map<String, Int> = mapOf(
        " " to 1,
        "dvdf" to 3
    )

    override fun algorithm(input: String): Int {
        val s = input

        val idxArr = IntArray(256) { -1 }

        var left=0
        var right=0
        var len=0
        var maxLen=0
        while(right < s.length){
            val arrIdx = s[right].toInt()%256
            val isRightInWindow =  idxArr[arrIdx] >= left

            if (isRightInWindow) {
                left = idxArr[arrIdx] + 1
            }
            idxArr[arrIdx] = right
            len = right-left+1
            maxLen = maxLen.coerceAtLeast(len)

            right++
        }
        return maxLen.coerceAtLeast(len)
    }

    override fun inputStringToInputType(input: String): String {
        return input
    }
}
