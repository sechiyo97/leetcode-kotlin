package solution

import common.to2DIntArray

class Sol_733_flood_fill: Solution.General<Sol_733_flood_fill.Params, Array<IntArray>>() {
    data class Params(val image: Array<IntArray>, val sr: Int, val sc: Int, val newColor: Int)

    override val givenTestCases: Map<String, Array<IntArray>> = mapOf(
        "[[1,1,1],[1,1,0],[1,0,1]] 1 1 2" to arrayOf(intArrayOf(2,2,2), intArrayOf(2,2,0), intArrayOf(2,0,1)),
        "[[0,0,0],[0,0,0]] 0 0 2" to arrayOf(intArrayOf(2,2,2), intArrayOf(2,2,2))
    )

    override fun algorithm(input: Params): Array<IntArray> {
        return arrayOf(intArrayOf(2,2,2), intArrayOf(2,2,2))
    }

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        val image = split[0].to2DIntArray()
        val sr = split[1].toInt()
        val sc = split[2].toInt()
        val newColor = split[3].toInt()
        return Params(image, sr, sc, newColor)
    }
}