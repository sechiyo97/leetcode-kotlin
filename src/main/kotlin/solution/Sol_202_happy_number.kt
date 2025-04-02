package solution

import Solution
import common.toIntArray
import kotlin.math.pow

// https://leetcode.com/problems/happy-number/
class Sol_202_happy_number :
    Solution.General<Sol_202_happy_number.Params, Boolean>() {
    fun isHappy(n: Int): Boolean {
        val appeared = mutableMapOf<Int, Boolean>()

        var curNum = n
        while (appeared[curNum] == null) {
            appeared[curNum] = true
            val sum = sumOfSquares(curNum)
            if (sum == 1) return true
            curNum = sum
        }
        return false
    }

    private fun sumOfSquares(n: Int): Int {
        var num = n
        var sum = 0
        while (num > 0) {
            val digit = num % 10
            sum += digit * digit
            num /= 10
        }
        return sum
    }

    override val givenTestCases: Map<String, Boolean> = mapOf(
        "19" to true,
        "2" to false,
    )

    override val customTestCases: Map<String, Boolean> = mapOf(
    )

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        val n = split[0].toInt()
        return Params(n)
    }

    override fun algorithm(input: Params): Boolean = isHappy(input.n)
    class Params(val n: Int)
}
