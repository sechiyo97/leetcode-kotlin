package solution

import Solution

class Sol_512_permutation_in_string: Solution.General<Sol_512_permutation_in_string.Params, Boolean>() {
    data class Params(val s1: String, val s2: String)
    override val givenTestCases: Map<String, Boolean> = mapOf(
        "ab eidbaooo" to true,
        "ab eidboaoo" to false
    )

    override fun algorithm(input: Params): Boolean {
        return false
    }

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        return Params(split[0], split[1])
    }

}

