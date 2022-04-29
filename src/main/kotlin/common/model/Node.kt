package common.model

import common.convertToString
import common.toIntArray
import kotlin.math.log2
import kotlin.math.pow

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
        val targetArray = Array<Int?>(2.toDouble().pow(depth.toDouble()).toInt()-1) { null }
        fillIntArray(this, 0, targetArray)

        var curNode: Node? = this
        while (curNode != null) {
            curNode = curNode.left
        }

        val mutableList = targetArray.toMutableList()
        for (i in 0 until depth) {
            mutableList.add((i+1)*(i+1), null)
        }

        return mutableList.toTypedArray()
    }
    private fun fillIntArray(node: Node?, curIndex: Int, targetArray: Array<Int?>) {
        node?:return
        targetArray[curIndex] = node.`val`
        val nextLeftIndex = curIndex + (curIndex + 1)
        val nextRightIndex = curIndex + (curIndex + 2)
        fillIntArray(node.left, nextLeftIndex, targetArray)
        fillIntArray(node.right, nextRightIndex, targetArray)
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
                val nextIndex = if (log2((index + 1).toDouble()).isInt()) null else index+1
                if (leftNextIndex < count) node.left = nodes[leftNextIndex]
                if (rightNextIndex < count) node.right = nodes[rightNextIndex]
                if (nextIndex != null && nextIndex < count) node.next = nodes[nextIndex]
            }

            return nodes[0]
        }
    }
}

private fun Double.isInt() = this.toInt().toDouble() == this