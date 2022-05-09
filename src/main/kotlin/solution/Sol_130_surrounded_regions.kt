package solution

import Solution
import common.to2DCharArray
import java.util.*

private val dirs = listOf(Pair(0,-1), Pair(0,1), Pair(-1,0), Pair(1,0))

class Sol_130_surrounded_regions: Solution.InPlaceArray<Array<CharArray>, Array<CharArray>>() {
    // solution: replace all 'O's connected to edges with 'R's, and then replace all other 'O's with 'X's. 
    fun solve(board: Array<CharArray>): Unit {
        if (board.isEmpty() || board[0].isEmpty()) return

        val m = board.size
        val n = board[0].size

        val visited = Array(board.size) { BooleanArray(board[0].size) }

        for (i in 0 until m) {
            if (board[i][0] == 'O') board.markIslandWith(i, 0, visited)
            if (board[i][n-1] == 'O') board.markIslandWith(i, n-1, visited)
        }
        for (j in 0 until n) {
            if (board[0][j] == 'O') board.markIslandWith(0, j, visited)
            if (board[m-1][j] == 'O') board.markIslandWith(m-1, j, visited)
        }
        for (i in 0 until m) {
            for (j in 0 until n) {
                board[i][j] = if (board[i][j] == 'R') 'O' else 'X'
            }
        }
    }
    var cnt=0
    private fun Array<CharArray>.markIslandWith(i: Int, j: Int, visited: Array<BooleanArray>) {
        val cells = mutableSetOf<Pair<Int,Int>>()
        val queue = LinkedList<Pair<Int,Int>>()
        val firstCell = Pair(i,j)
        queue.offer(firstCell)
        cells.add(firstCell)
        while(queue.isNotEmpty()) {
            val cell = queue.poll()
            dirs.map { Pair(cell.first+it.first, cell.second+it.second) }
                .filter { it.first >= 0 && it.second >= 0 && it.first < this.size && it.second < this[0].size && this[it.first][it.second] == 'O' }
                .forEach {
                    if (visited[it.first][it.second].not()) {
                        visited[it.first][it.second] = true
                        queue.offer(it)
                        cells.add(it)
                    }
                }
        }
        cells.forEach {
            this[it.first][it.second] = 'R'
        }
    }

    override val givenTestCases: Map<String, Array<CharArray>> = mapOf(
        "[XXXX,XOOX,XXOX,XOXX]" to "[XXXX,XXXX,XXXX,XOXX]".to2DCharArray(),
        "[X]" to "[X]".to2DCharArray()
    )
    override val customTestCases: Map<String, Array<CharArray>> = mapOf(
        "[OXXOX,XOOXO,XOXOX,OXOOO]" to "[OXXOX,XXXXO,XXXOX,OXOOO]".to2DCharArray(),
        "[OOO,OOO,OOO]" to "[OOO,OOO,OOO]".to2DCharArray()
    )

    override fun inputStringToInputType(input: String): Array<CharArray> = input.to2DCharArray()
    override fun algorithm(input: Array<CharArray>) = solve(input)
    override fun getTargetArrayFromInput(input: Array<CharArray>): Array<CharArray> = input
}