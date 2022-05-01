package solution

import Solution

// https://leetcode.com/problems/fizz-buzz/
class Sol_412_fizz_buzz: Solution.General<Int, List<String>>() {
    fun fizzBuzz(n: Int): List<String> {
        val answer = mutableListOf<String>()
        for (i in 1..n) {
            val fizz = i%3 == 0
            val buzz = i%5 == 0
            val result = if(fizz&&buzz) "FizzBuzz" else if(fizz) "Fizz" else if(buzz) "Buzz" else i.toString()
            answer.add(result)
        }
        return answer
    }

    override val givenTestCases: Map<String, List<String>> = mapOf(
        "3" to listOf("1", "2", "Fizz"),
        "5" to listOf("1", "2", "Fizz", "4", "Buzz"),
        "15" to listOf("1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz")
    )

    override fun algorithm(input: Int): List<String> = fizzBuzz(input)
    override fun inputStringToInputType(input: String): Int {
        return Integer.valueOf(input)
    }
}

