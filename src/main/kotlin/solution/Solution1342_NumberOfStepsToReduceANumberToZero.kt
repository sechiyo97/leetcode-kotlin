package solution

import Solution

class Solution1342_NumberOfStepsToReduceANumberToZero : Solution<Int, Int>() {
    override val givenTestCases = mapOf(
        "14" to 6,
        "8" to 4,
        "123" to 12
    )

    override fun algorithm(params: Int): Int {
        var steps = 0
        var curNum = params
        while (curNum > 0) {
            if (curNum%2 == 0) curNum/=2 else curNum--
            steps++
        }
        return steps
    }

    override fun inputToParamType(input: String): Int {
        return input.toInt()
    }
}
