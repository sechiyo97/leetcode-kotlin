package solution

import Solution

// https://leetcode.com/problems/climbing-stairs/
class Sol_70_climbing_stairs: Solution.General<Int, Int>() {

    fun climbStairs(n: Int): Int {
        if (n==1) return 1
        var result1 = 1
        var result2 = 2
        for (i in 2 until n) {
            val temp = result2
            result2 += result1
            result1 = temp
        }
        return result2
    }

    override val givenTestCases: Map<String, Int> = mapOf(
        "2" to 2,
        "3" to 3,
        "44" to 1134903170,
        "1" to 1
    )

    override fun inputStringToInputType(input: String): Int = input.toInt()
    override fun algorithm(input: Int): Int = climbStairs(input)
}