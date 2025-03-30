package solution

import Solution

// https://leetcode.com/problems/valid-parentheses/
class Sol_20_valid_parentheses: Solution.General<Sol_20_valid_parentheses.Params, Boolean>() {
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        s.forEach {
            when(it) {
                '(', '[', '{' -> stack.addLast(it)
                ')' -> if (stack.lastOrNull() == '(') stack.removeLast() else return false
                ']' -> if (stack.lastOrNull() == '[') stack.removeLast() else return false
                '}' -> if (stack.lastOrNull() == '{') stack.removeLast() else return false
            }
        }
        return stack.isEmpty()
    }

    override val givenTestCases: Map<String, Boolean> = mapOf(
        "()" to true,
        "()[]{}" to true,
        "(]" to false,
        "([])" to true,
    )
    override val customTestCases: Map<String, Boolean> = mapOf(
        "[" to false,
        "]" to false,
        "(){}}{" to false,
    )


    override fun inputStringToInputType(input: String): Params {
        return Params(input)
    }
    override fun algorithm(input: Params): Boolean = isValid(input.s)
    class Params(val s: String)
}
