package solution

import Solution
import common.to2DIntArray

class Sol_354_russian_doll_envelopes : Solution.General<Array<IntArray>, Int>() {
    fun maxEnvelopes(envelopes: Array<IntArray>): Int {
        envelopes.sortWith(Comparator { a, b -> if (a[0] == b[0]) b[1] - a[1] else a[0] - b[0] })
        // largestHeights[i]: the largest-height doll of a valid list that consists of i dolls
        val largestHeights = mutableListOf<Int>()

        envelopes.forEach {
            var left = 0
            var right = largestHeights.size
            while (left < right) {
                val mid = (right + left) shr 1
                if (largestHeights[mid] >= it[1]) right = mid
                else left = mid + 1
            }
            if (left == largestHeights.size) largestHeights.add(it[1])
            else largestHeights[left] = it[1]
        }
        return largestHeights.size
    }

    override val givenTestCases: Map<String, Int> = mapOf(
        "[[5,4],[6,4],[6,7],[2,3]]" to 3,
        "[[1,1],[1,1],[1,1]]" to 1
    )

    override fun inputStringToInputType(input: String): Array<IntArray> = input.to2DIntArray()
    override fun algorithm(input: Array<IntArray>): Int = maxEnvelopes(input)
}