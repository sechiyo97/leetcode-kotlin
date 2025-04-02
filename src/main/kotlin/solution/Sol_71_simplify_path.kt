package solution

import Solution

// https://leetcode.com/problems/simplify-path/
class Sol_71_simplify_path: Solution.General<Sol_71_simplify_path.Params, String>() {
    fun simplifyPath(path: String): String {
        val stack = ArrayDeque<String>()
        path.split('/').forEach {
            when(it) {
                "", "." -> {
                    // do nothing
                }
                ".." -> {
                    stack.removeLastOrNull()
                }
                else -> {
                    stack.add(it)
                }
            }
        }
        return "/" + stack.joinToString("/")
    }

    override val givenTestCases: Map<String, String> = mapOf(
        "/home/" to "/home",
        "/home//foo/" to "/home/foo",
        "/home/user/Documents/../Pictures" to "/home/user/Pictures",
        "/../" to "/",
        "/.../a/../b/c/../d/./" to "/.../b/d"
    )

    override val customTestCases: Map<String, String> = mapOf(
        "/.../../b/c/../../d/./" to "/d"
    )


    override fun inputStringToInputType(input: String): Params {
        return Params(input)
    }
    override fun algorithm(input: Params): String = simplifyPath(input.s)
    class Params(val s: String)
}
