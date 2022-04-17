package solution

import Solution

class Solution383_RansomNote: Solution<Solution383_RansomNote.Params, Boolean>(){
    class Params(val ransomNote: String, val magazine: String)

    override val givenTestCases: Map<String, Boolean> = mapOf(
        "a b" to false,
        "aa ab" to false,
        "aa aab" to true
    )

    override fun algorithm(params: Params): Boolean {
        val ransomNote = params.ransomNote
        val magazine = params.magazine

        val atoz = List(26) { 0 }.toMutableList()
        magazine.forEach { atoz[it.toInt() - 97]++}
        ransomNote.forEach {
            val index = it.toInt() - 97
            if (atoz[index] <= 0) return false
            else atoz[index]--
        }
        return true
    }

    override fun inputToParamType(input: String): Params {
        val split = input.split(" ")
        return Params(split[0], split[1])
    }
}
