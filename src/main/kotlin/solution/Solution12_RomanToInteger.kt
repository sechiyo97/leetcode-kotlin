package solution

import Solution

class Solution12_RomanToInteger : Solution<String, Int>() {
    override val givenTestCases = mapOf(
        "III" to 3,
        "IV" to 4,
        "LVIII" to 58,
        "MCMXCIV" to 1994
    )

    override fun algorithm(params: String): Int {
        var result = 0
        var lastRomanIntValue = 0
        params.forEach { char ->
            val currentRomanIntValue = romanMap[char] ?: 0
            if (currentRomanIntValue > lastRomanIntValue)
                lastRomanIntValue = currentRomanIntValue - lastRomanIntValue
            else {
                result += lastRomanIntValue
                lastRomanIntValue = currentRomanIntValue
            }
        }
        return result + lastRomanIntValue
    }

    override fun inputToParamType(input: String): String {
        return input
    }

    private val romanMap = mapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000
    )
}
