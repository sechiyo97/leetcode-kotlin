package solution

import Solution


class Sol_844_backspace_string_compare: Solution.General<Sol_844_backspace_string_compare.Params, Boolean>() {
    fun backspaceCompare(s: String, t: String): Boolean {
        var sIdx = s.length
        var tIdx = t.length
        while(true) {
            sIdx = getBeforeIndex(s, sIdx)
            tIdx = getBeforeIndex(t, tIdx)
            if (sIdx == -1 && tIdx == -1) return true
            else if (sIdx == -1 || tIdx == -1) return false
            if (s[sIdx] != t[tIdx]) return false
        }
    }

    private fun getBeforeIndex(str: String, idx: Int): Int {
        var curIdx = idx
        var eraseCnt = 0

        if (idx == str.length && str[idx-1] != '#') return idx-1
        else curIdx--

        while (curIdx >= 0 && (eraseCnt > 0 || str[curIdx] == '#')) {
            if (str[curIdx] == '#') eraseCnt++
            else if (eraseCnt > 0) eraseCnt--
            curIdx--
        }
        return curIdx
    }

    override val givenTestCases: Map<String, Boolean> = mapOf(
        "ab#c ad#c" to true,
        "ab## c#d#" to true,
        "a#c b" to false
    )
    override val customTestCases: Map<String, Boolean> = mapOf(
        "xywrrmp xywrrmu#p" to true,
        "bxj##tw bxj###tw" to false,
        "nzp#o#g b#nzp#o#g" to true,
        "a#c b" to false,
        "ab#cc# ad#c" to true
    )

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        return Params(split[0], split[1])
    }
    override fun algorithm(input: Params): Boolean = backspaceCompare(input.s, input.t)
    class Params(val s: String, val t: String)
}