package solution

import Solution

// https://leetcode.com/problems/climbing-stairs/
class Sol_70_climbing_stairs: Solution.General<Int, Int>() {
    val results = IntArray(46)
    init {
        results[0] = 1
        results[1] = 1
    }
    fun climbStairs(n: Int): Int {
        for (i in 2 until n+1) results[i] = results[i-1] + results[i-2]
        return results[n]
    }

    override val givenTestCases: Map<String, Int> = mapOf(
        "2" to 2,
        "3" to 3,
        "44" to 1134903170
    )

    override fun inputStringToInputType(input: String): Int = input.toInt()
    override fun algorithm(input: Int): Int = climbStairs(input)
}