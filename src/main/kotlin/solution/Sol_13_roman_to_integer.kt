package solution

// https://leetcode.com/problems/roman-to-integer/
class Sol_13_roman_to_integer : Solution.General<String, Int>() {
    fun romanToInt(s: String): Int {
        var result = 0
        var lastRomanIntValue = 0
        s.forEach { char ->
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

    private val romanMap = mapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000
    )

    override val givenTestCases = mapOf(
        "III" to 3,
        "IV" to 4,
        "LVIII" to 58,
        "MCMXCIV" to 1994
    )

    override fun algorithm(input: String): Int = romanToInt(input)
    override fun inputStringToInputType(input: String): String {
        return input
    }
}
