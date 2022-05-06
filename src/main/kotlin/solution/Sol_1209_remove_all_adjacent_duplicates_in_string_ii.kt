package solution

class Sol_1209_remove_all_adjacent_duplicates_in_string_ii: Solution.General<Sol_1209_remove_all_adjacent_duplicates_in_string_ii.Params, String>() {
    fun removeDuplicates(s: String, k: Int): String {
        return "aa"
    }

    override val givenTestCases: Map<String, String> = mapOf(
        "abcd 2" to "abcd",
        "deeedbbcccbdaa 3" to "aa",
        "pbbcggttciiippooaais 2" to "ps"
    )

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        val s = split[0]
        val k = split[1].toInt()
        return Params(s, k)
    }

    override fun algorithm(input: Params): String = removeDuplicates(input.s, input.k)
    class Params(val s: String, val k: Int)
}