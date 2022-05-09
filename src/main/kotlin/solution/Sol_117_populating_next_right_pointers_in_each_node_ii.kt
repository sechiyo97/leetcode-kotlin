package solution

import Solution
import common.model.Node
import common.toNullableIntArray
import java.util.*

class Sol_117_populating_next_right_pointers_in_each_node_ii: Solution.General<Node?, Node?>() {
    fun connect(root: Node?): Node? {
        val queue = LinkedList<Pair<Int, Node?>>() // depth, node
        queue.add(Pair(0, root))

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
        return root
    }

    override val givenTestCases: Map<String, Node?> = mapOf(
        "[1,2,3,4,5,#,7]" to Node.fromNullableIntArray("[1,#,2,3,#,4,5,7,#]".toNullableIntArray())?.connect()
    )
    override fun inputStringToInputType(input: String): Node? = Node.fromNullableIntArray(input.toNullableIntArray())
    override fun algorithm(input: Node?): Node? = connect(input)
}