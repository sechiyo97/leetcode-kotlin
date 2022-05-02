package solution

// https://leetcode.com/problems/number-of-1-bits/
class Sol_191_number_of_1_bits: Solution.General<Int, Int>() {
    // my solution
    fun hammingWeight(n: Int): Int {
        var i = if (n>=0) n else n.inv()
        var cnt = 0
        while (i!=0) {
            if (i%2!=0) cnt++
            i = i shr 1
        }
        return if (n>=0) cnt else 32-cnt
    }

    // Java Integer.bitCount(int i) method
    fun bitCountInJavaInteger(n:Int):Int {
        var i = n
        i = i - (i ushr 1 and 0x55555555)
        i = (i and 0x33333333) + (i ushr 2 and 0x33333333)
        i = i + (i ushr 4) and 0x0f0f0f0f
        i = i + (i ushr 8)
        i = i + (i ushr 16)
        return i and 0x3f
    }

    override val givenTestCases: Map<String, Int> = mapOf(
        "00000000000000000000000000001011" to 3,
        "00000000000000000000000010000000" to 1,
        "11111111111111111111111111111101" to 31,
        "00000000000000000000000000000000" to 0,
        "10000000000000000000000000000000" to 1,
        "11111111111111111111111111111111" to 32,
        "10101010101010101010101010101010" to 16,
        "11111111111111111111111111111110" to 31
    )

    override fun inputStringToInputType(input: String): Int = input.toUInt(2).toInt()
    override fun algorithm(input: Int): Int = hammingWeight(input)
}