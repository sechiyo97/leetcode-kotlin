package solution

import Solution


class Sol_318_maximum_product_of_word_lengths: Solution.General<Array<String>, Int>() {
    fun maxProduct(words: Array<String>): Int {
        var max = 0
        val bits = IntArray(words.size)
        words.forEachIndexed { index, word ->
            word.forEach {
                val curCharBit = 1 shl (it-'a')
                bits[index] = bits[index] or curCharBit
            }
        }
        for (i in words.indices) {
            for (j in i+1 until words.size) {
                if (bits[i] and bits[j] == 0) {
                    val len = words[i].length * words[j].length
                    max = max.coerceAtLeast(len)
                }
            }
        }
        return max
    }

    override val givenTestCases: Map<String, Int> = mapOf(
        "abcw,baz,foo,bar,xtfn,abcdef" to 16,
        "a,ab,abc,d,cd,bcd,abcd" to 4,
        "a,aa,aaa,aaaa" to 0
    )
    override fun inputStringToInputType(input: String): Array<String> = input.split(',').toTypedArray()
    override fun algorithm(input: Array<String>): Int = maxProduct(input)
}