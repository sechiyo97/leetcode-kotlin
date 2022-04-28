package solution

import common.to2DIntArray

class Sol_695_max_area_of_island: Solution.General<Array<IntArray>, Int>() {
    override val givenTestCases: Map<String, Int> = mapOf(
        "[[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0]," +
        "[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0]," +
        "[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0]," +
        "[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]" to 6,
        "[[0,0,0,0,0,0,0,0]]" to 0
    )

    override fun algorithm(input: Array<IntArray>): Int {
        return 0
    }

    override fun inputStringToInputType(input: String): Array<IntArray> {
        return input.to2DIntArray()
    }
}