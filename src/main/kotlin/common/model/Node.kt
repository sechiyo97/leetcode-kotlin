package common.model

import common.convertToString
import common.toNullableIntArray
import java.util.*

fun main() {
    val node = Node.fromNullableIntArray("[1,2,3,4,5,6,7]".toNullableIntArray())
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

    override fun equals(other: Any?): Boolean {
        return if (other is Node) {
            val leftCompare = this.left?.equals(other.left) ?: (other.left == null)
            val rightCompare = this.right?.equals(other.right) ?: (other.right == null)
            val nextCompare = this.next?.equals(other.next) ?: (other.next == null)
            this.`val` == other.`val` && leftCompare && rightCompare && nextCompare
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

    fun connect(): Node? {
        val queue = LinkedList<Pair<Int, Node?>>() // depth, node
        queue.add(Pair(0, this))

        val nodesInLine = mutableListOf<Node>()
        while (queue.isNotEmpty()) {
            val depthAndNode = queue.poll()

            val depth = depthAndNode.first
            val node = depthAndNode.second

            if (node != null) nodesInLine.add(node)

            if (node?.left != null) queue.add(Pair(depth+1, node.left))
            if (node?.right != null)  queue.add(Pair(depth+1, node.right))

            val nextNode = queue.peek()
            if (nextNode == null || nextNode.first != depth) {
                for (i in 0 until nodesInLine.size-1) {
                    nodesInLine[i].next = nodesInLine[i+1]
                }
                nodesInLine.clear()
            }
        }
        return this
    }

    companion object {
        fun fromNullableIntArray(array: Array<Int?>): Node? {
            if (array.isEmpty()) return null
            val nodes = array.filterNotNull().map { Node(it) }
            val count = nodes.size

            nodes.forEachIndexed { index, node ->
                val leftNextIndex = index + (index + 1)
                val rightNextIndex = index + (index + 2)
                if (leftNextIndex < count) node.left = nodes[leftNextIndex]
                if (rightNextIndex < count) node.right = nodes[rightNextIndex]
            }

            return nodes[0]
        }
    }
}

