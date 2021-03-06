package solution

import Solution
import common.model.Node
import common.toNullableIntArray

// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
class Sol_116_populating_next_right_pointers_in_each_node: Solution.General<Node?, Node?>() {
    fun connect(root: Node?): Node? {
        val totalDepth = root?.totalDepth ?: 0
        val nodeArray = createNodeArray(root, totalDepth)
        val lastNodeIndices = IntArray(totalDepth)
        val pows = IntArray(totalDepth)
        for(i in 0 until totalDepth) {
            pows[i] = if (i==0) 1 else pows[i-1]*2
            lastNodeIndices[i] = if (i==0) 0 else lastNodeIndices[i-1] + pows[i]
        }

        var curDepth=0
        nodeArray.forEachIndexed { index, node ->
            val isLastNodeInRow = index == lastNodeIndices[curDepth]
            if (isLastNodeInRow) curDepth++
            if (isLastNodeInRow.not()) node?.next = nodeArray[index+1]
        }
        return root
    }

    private fun createNodeArray(root: Node?, totalDepth: Int): Array<Node?> {
        val nodeArray = Array<Node?>(pow(2,totalDepth)-1) { null }
        fillNodeArray(root, 0, nodeArray)
        return nodeArray
    }
    private fun fillNodeArray(node: Node?, curIndex: Int, targetArray: Array<Node?>) {
        node?:return
        targetArray[curIndex] = node
        val nextLeftIndex = curIndex + (curIndex + 1)
        val nextRightIndex = curIndex + (curIndex + 2)
        fillNodeArray(node.left, nextLeftIndex, targetArray)
        fillNodeArray(node.right, nextRightIndex, targetArray)
    }

    private fun pow(value: Int, times: Int): Int {
        var result = 1
        for (i in 0 until times) result*=value
        return result
    }

    private val Node.totalDepth get(): Int {
        val leftDepth = left?.totalDepth ?: 0
        val rightDepth = right?.totalDepth ?: 0
        val maxDepth = leftDepth.coerceAtLeast(rightDepth)
        return 1 + maxDepth
    }

    override val givenTestCases: Map<String, Node?> = mapOf(
        "[1,2,3,4,5,6,7]" to Node.fromNullableIntArray("[1,2,3,4,5,6,7]".toNullableIntArray())?.connect()
    )
    override val customTestCases: Map<String, Node?> = mapOf(
        "[-1,0,1,2,3,4,5,6,7,8,9,10,11,12,13]" to Node.fromNullableIntArray("[-1,0,1,2,3,4,5,6,7,8,9,10,11,12,13]".toNullableIntArray())?.connect()
    )

    override fun algorithm(input: Node?): Node? = connect(input)
    override fun inputStringToInputType(input: String): Node? {
        return Node.fromNullableIntArray(input.toNullableIntArray())
    }
}