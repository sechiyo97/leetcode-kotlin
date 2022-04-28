package solution

import Solution

class Sol_1342_number_of_steps_to_reduce_a_number_to_zero : Solution.General<Int, Int>() {
    override val givenTestCases = mapOf(
        "14" to 6,
        "8" to 4,
        "123" to 12
    )

    override fun algorithm(input: Int): Int {
        var steps = 0
        var curNum = input
        while (curNum > 0) {
            if (curNum%2 == 0) curNum/=2 else curNum--
            steps++
        }
        return steps
    }

    override fun inputStringToInputType(input: String): Int {
        return input.toInt()
    }
}
