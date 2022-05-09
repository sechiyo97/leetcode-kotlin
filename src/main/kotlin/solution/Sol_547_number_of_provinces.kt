package solution

import Solution
import common.to2DIntArray

class Sol_547_number_of_provinces: Solution.General<Array<IntArray>, Int>() {
    fun findCircleNum(isConnected: Array<IntArray>): Int {
        var count = 0
        for (i in isConnected.indices) {
            if (isConnected[i][0] != -1) {
                isConnected.removeConnection(i)
                count++
            }
        }
        return count
    }

    private fun Array<IntArray>.removeConnection(i: Int) {
        this[i][0] = -1
        for (j in this[i].indices) {
            val connected = this[i][j] == 1
            if (connected && this[j][0] != -1) this.removeConnection(j)
        }
    }

    override val givenTestCases: Map<String, Int> = mapOf(
        "[[1,1,0],[1,1,0],[0,0,1]]" to 2,
        "[[1,0,0],[0,1,0],[0,0,1]]" to 3
    )

    override fun inputStringToInputType(input: String): Array<IntArray> = input.to2DIntArray()
    override fun algorithm(input: Array<IntArray>): Int = findCircleNum(input)
}