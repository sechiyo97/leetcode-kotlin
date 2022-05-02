package solution

// https://leetcode.com/problems/power-of-two/
class Sol_231_power_of_two: Solution.General<Int, Boolean>() {
    fun isPowerOfTwo(n: Int): Boolean = n>0 && n.and(n-1) == 0

    override val givenTestCases: Map<String, Boolean> = mapOf(
        "1" to true,
        "16" to true,
        "3" to false
    )
    override val customTestCases: Map<String, Boolean> = mapOf(
        "0" to false,
        "-2147483648" to false,
        "-1" to false
    )

    override fun inputStringToInputType(input: String): Int = input.toInt()
    override fun algorithm(input: Int): Boolean = isPowerOfTwo(input)
}