package solution

// https://leetcode.com/problems/climbing-stairs/
class Sol_70_climbing_stairs: Solution.General<Int, Int>() {
    fun climbStairs(n: Int): Int {
        return 0
    }

    override val givenTestCases: Map<String, Int> = mapOf(
        "2" to 2,
        "3" to 3
    )

    override fun inputStringToInputType(input: String): Int = input.toInt()
    override fun algorithm(input: Int): Int = climbStairs(input)
}