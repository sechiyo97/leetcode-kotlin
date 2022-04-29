package solution

import common.to2DIntArray

class Sol_994_rotting_oranges: Solution.General<Array<IntArray>, Int>() {
    override val givenTestCases: Map<String, Int> = mapOf(
        "[[2,1,1],[1,1,0],[0,1,1]]" to 4,
        "[[2,1,1],[0,1,1],[1,0,1]]" to -1,
        "[[0,2]]" to 0
    )

    override fun algorithm(input: Array<IntArray>): Int {
        return 0
    }

    override fun inputStringToInputType(input: String): Array<IntArray> {
        return input.to2DIntArray()
    }
}