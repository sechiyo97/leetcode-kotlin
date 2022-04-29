package solution.sample

import common.to2DIntArray

class Sol_542_01_matrix: Solution.General<Array<IntArray>, Array<IntArray>>() {
    override val givenTestCases: Map<String, Array<IntArray>> = mapOf(
        "[[0,0,0],[0,1,0],[0,0,0]]" to "[[0,0,0],[0,1,0],[1,2,1]]".to2DIntArray(),
        "[[0,0,0],[0,1,0],[1,1,1]]" to "[[0,0,0],[0,1,0],[0,0,0]]".to2DIntArray()
    )

    override fun algorithm(input: Array<IntArray>): Array<IntArray> {
        return input
    }

    override fun inputStringToInputType(input: String): Array<IntArray> {
        return input.to2DIntArray()
    }
}