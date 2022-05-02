package solution

// https://leetcode.com/problems/reverse-bits/submissions/
class Sol_190_reverse_bits: Solution.General<Int, Int>() {
    // you need treat n as an unsigned value
    fun reverseBits(n:Int):Int {
        var original = n
        var reversed = 0
        for (i in 0 until 32) {
            reversed = reversed shl 1
            reversed += original and 1
            original = original ushr 1
        }
        return reversed
    }

    override val givenTestCases: Map<String, Int> = mapOf(
        "00000010100101000001111010011100" to "00111001011110000010100101000000".toUInt(2).toInt(),
        "11111111111111111111111111111101" to "10111111111111111111111111111111".toUInt(2).toInt()
    )

    override fun inputStringToInputType(input: String): Int = input.toUInt(2).toInt()
    override fun algorithm(input: Int): Int = reverseBits(input)
}