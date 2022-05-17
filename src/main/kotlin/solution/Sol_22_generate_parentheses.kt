package solution

import Solution
import java.util.*

class Sol_22_generate_parentheses: Solution.General<Int, List<String>>() {
    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()
        val queue = LinkedList<Triple<String, Int, Int>>()
        queue.offer(Triple("", 0, 0))

        while (queue.isNotEmpty()) {
            val next = queue.poll()
            val string = next.first
            val left = next.second
            val right = next.third

            when {
                right == n -> result.add(string)
                left == n -> result.add("$string${")".repeat(n - right)}")
                else -> {
                    if (left == right)
                        queue.offer(Triple("$string(", left + 1, right))
                    else {
                        queue.offer(Triple("$string(", left + 1, right))
                        queue.offer(Triple("$string)", left, right + 1))
                    }
                }
            }
        }

        return result
    }

    override val givenTestCases: Map<String, List<String>> = mapOf(
        "3" to listOf("((()))", "(()())", "(())()", "()(())", "()()()"),
        "1" to listOf("()")
    )

    override fun inputStringToInputType(input: String): Int = input.toInt()
    override fun algorithm(input: Int): List<String> = generateParenthesis(input)
    override fun checkEquals(result: List<String>, expected: List<String>?): Boolean {
        expected ?: return false
        val both = expected.toMutableList().apply { addAll(result) }.toSet()
        both.forEach { str ->
            if (expected.count { it == str } != result.count { it == str }) return false
        }
        return true
    }
}