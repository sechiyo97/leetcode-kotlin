package common.model

import common.convertToString
import common.toIntArray
import kotlin.math.log2

fun main() {
    val node = Node.fromIntArray("[1,2,3,4,5,6,7]".toIntArray())
    print(node.toString())
}

// for prob. 116. unknown if this class will be further used.
class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var next: Node? = null

    val depth get(): Int {
        val leftDepth = left?.depth ?: 0
        val rightDepth = right?.depth ?: 0
        val maxDepth = leftDepth.coerceAtLeast(rightDepth)
        return 1 + maxDepth
    }

    fun toNullableIntArray(): Array<Int?> {
        val result = mutableListOf<Node?>()
        var curNode: Node? = this
        while (curNode != null) {
            var curNodeRow: Node? = curNode
            while (curNodeRow != null) {
                result.add(curNodeRow)
                curNodeRow = curNodeRow.next
            }
            result.add(null)
           curNode = curNode.left
        }
        return result.map { it?.`val` }.toTypedArray()
    }
    private fun fillNodeArray(node: Node?, curIndex: Int, targetArray: Array<Node?>) {
        node?:return
        targetArray[curIndex] = node
        val nextLeftIndex = curIndex + (curIndex + 1)
        val nextRightIndex = curIndex + (curIndex + 2)
        fillNodeArray(node.left, nextLeftIndex, targetArray)
        fillNodeArray(node.right, nextRightIndex, targetArray)
    }

    override fun equals(other: Any?): Boolean {
        return if (other is Node) {
            val leftCompare = this.left?.equals(other.left) ?: (other.left == null)
            val rightCompare = this.right?.equals(this.right) ?: (other.right == null)
            val nextCompare = this.next?.equals(this.next) ?: (other.next == null)
            leftCompare && rightCompare && nextCompare
        } else false
    }

    override fun toString(): String {
        return this.toNullableIntArray().convertToString()
    }

    override fun hashCode(): Int {
        var result = `val`
        result = 31 * result + (left?.hashCode() ?: 0)
        result = 31 * result + (right?.hashCode() ?: 0)
        result = 31 * result + (next?.hashCode() ?: 0)
        return result
    }

    companion object {
        fun fromIntArray(array: IntArray): Node? {
            if (array.isEmpty()) return null
            val count = array.size
            val nodes = Array(count) { Node(array[it]) }

            nodes.forEachIndexed { index, node ->
                val leftNextIndex = index + (index + 1)
                val rightNextIndex = index + (index + 2)
                val isLastOfRow = log2((index + 2).toDouble()).isInt()
                val nextIndex = if (isLastOfRow) null else index+1
                if (leftNextIndex < count) node.left = nodes[leftNextIndex]
                if (rightNextIndex < count) node.right = nodes[rightNextIndex]
                if (nextIndex != null && nextIndex < count) node.next = nodes[nextIndex]
            }

            return nodes[0]
        }
    }
}

private fun Double.isInt() = this.toInt().toDouble() == this
