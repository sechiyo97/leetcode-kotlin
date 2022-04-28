package common.model

import common.convertToString
import kotlin.math.pow

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    val depth get(): Int {
        val leftDepth = left?.depth ?: 0
        val rightDepth = right?.depth ?: 0
        val maxDepth = leftDepth.coerceAtLeast(rightDepth)
        return 1 + maxDepth
    }

    fun toNullableIntArray(): Array<Int?> {
        val targetArray = Array<Int?>(2.toDouble().pow(depth.toDouble()).toInt()-1) { null }
        fillIntArray(this, 0, targetArray)

        var curNode: TreeNode? = this
        val list = mutableListOf<Int>()
        while (curNode != null) {
            list.add(curNode.`val`)
            curNode = curNode.left
        }
        return targetArray
    }
    private fun fillIntArray(node: TreeNode?, curIndex: Int, targetArray: Array<Int?>) {
        node?:return
        targetArray[curIndex] = node.`val`
        val nextLeftIndex = curIndex + (curIndex + 1)
        val nextRightIndex = curIndex + (curIndex + 2)
        fillIntArray(node.left, nextLeftIndex, targetArray)
        fillIntArray(node.right, nextRightIndex, targetArray)
    }

    override fun equals(other: Any?): Boolean {
        return if (other is TreeNode) {
            val leftCompare = this.left?.equals(other.left) ?: (other.left == null)
            val rightCompare = this.right?.equals(this.right) ?: (other.right == null)
            leftCompare && rightCompare
        } else false
    }

    override fun toString(): String {
        return this.toNullableIntArray().convertToString()
    }

    override fun hashCode(): Int {
        var result = `val`
        result = 31 * result + (left?.hashCode() ?: 0)
        result = 31 * result + (right?.hashCode() ?: 0)
        return result
    }
}

fun Array<Int?>.toRootTreeNode(): TreeNode? {
    if (this.isEmpty()) return null
    val firstNode = this[0] ?: return null

    val headNode = TreeNode(firstNode)
    fillTreeNode(headNode, 0)

    return headNode
}
private fun Array<Int?>.fillTreeNode(node: TreeNode?, index: Int) {
    node ?: return
    val leftNodeIndex = index + (index + 1)
    val rightNodeIndex = index + (index + 2)

    if (leftNodeIndex < this.size) {
        val leftValue = this[leftNodeIndex]
        node.left = if (leftValue != null) TreeNode(leftValue) else null
        this.fillTreeNode(node.left, leftNodeIndex)
    }
    if (rightNodeIndex < this.size) {
        val rightValue = this[rightNodeIndex]
        node.right = if (rightValue != null) TreeNode(rightValue) else null
        this.fillTreeNode(node.right, rightNodeIndex)
    }
}