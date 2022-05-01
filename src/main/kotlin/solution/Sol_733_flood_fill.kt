package solution

import common.to2DIntArray

// https://leetcode.com/problems/flood-fill/
class Sol_733_flood_fill: Solution.General<Sol_733_flood_fill.Params, Array<IntArray>>() {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
        val orgColor = image[sr][sc]
        image[sr][sc] = newColor
        image.floodFill4Direction(sr, sc, orgColor, newColor)
        return image
    }

    private fun Array<IntArray>.floodFill4Direction(sr: Int, sc: Int, orgColor: Int, newColor: Int) {
        if (this.isEmpty()) return
        if (sr < this.lastIndex && this[sr+1][sc] == orgColor && this[sr+1][sc] != newColor) {
            this[sr+1][sc] = newColor
            this.floodFill4Direction(sr+1, sc, orgColor, newColor)
        }
        if (sr > 0 && this[sr-1][sc] == orgColor && this[sr-1][sc] != newColor) {
            this[sr-1][sc] = newColor
            this.floodFill4Direction(sr-1, sc, orgColor, newColor)
        }
        if (sc < this[0].lastIndex && this[sr][sc+1] == orgColor && this[sr][sc+1] != newColor) {
            this[sr][sc+1] = newColor
            this.floodFill4Direction(sr, sc+1, orgColor, newColor)
        }
        if (sc > 0 && this[sr][sc-1] == orgColor && this[sr][sc-1] != newColor) {
            this[sr][sc-1] = newColor
            this.floodFill4Direction(sr, sc-1, orgColor, newColor)
        }
    }

    override val givenTestCases: Map<String, Array<IntArray>> = mapOf(
        "[[1,1,1],[1,1,0],[1,0,1]] 1 1 2" to arrayOf(intArrayOf(2,2,2), intArrayOf(2,2,0), intArrayOf(2,0,1)),
        "[[0,0,0],[0,0,0]] 0 0 2" to arrayOf(intArrayOf(2,2,2), intArrayOf(2,2,2))
    )
    override val customTestCases: Map<String, Array<IntArray>> = mapOf(
        "[[0,0,0],[0,1,0]] 1 1 2" to arrayOf(intArrayOf(0,0,0), intArrayOf(0,2,0)),
        "[[0,0,0],[0,1,1]] 1 1 1" to arrayOf(intArrayOf(0,0,0), intArrayOf(0,1,1))
    )

    override fun algorithm(input: Params): Array<IntArray> = floodFill(input.image, input.sr, input.sc, input.newColor)
    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        val image = split[0].to2DIntArray()
        val sr = split[1].toInt()
        val sc = split[2].toInt()
        val newColor = split[3].toInt()
        return Params(image, sr, sc, newColor)
    }
    class Params(val image: Array<IntArray>, val sr: Int, val sc: Int, val newColor: Int)
}