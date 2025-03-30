package solution

import Solution
import common.model.TreeNode
import common.toDoubleArray
import common.toNullableIntArray
import java.util.*

// https://leetcode.com/problems/average-of-levels-in-binary-tree/
class Sol_637_average_of_levels_in_binary_tree :
    Solution.General<Sol_637_average_of_levels_in_binary_tree.Params, DoubleArray>() {
    fun averageOfLevels(root: TreeNode?): DoubleArray {
        if (root == null) return doubleArrayOf()
        val result = mutableListOf<Double>() // sum, count
        val queue: Queue<TreeNode> = LinkedList() // depth, node

        queue.offer(root)
        while(queue.isNotEmpty()) {
            val size = queue.size
            var sum = 0.0
            repeat(size) {
                val node = queue.poll()
                sum += node.`val`
                if (node.left != null) queue.offer(node.left!!)
                if (node.right != null) queue.offer(node.right!!)
            }
            result.add(sum / size)
        }

        return result.toDoubleArray()
    }

    override val givenTestCases: Map<String, DoubleArray> = mapOf(
        "[3,9,20,null,null,15,7]" to "[3.00000,14.50000,11.00000]".toDoubleArray(),
        "[3,9,20,15,7]" to "[3.00000,14.50000,11.00000]".toDoubleArray(),
    )

    override val customTestCases: Map<String, DoubleArray> = mapOf(
    )

    override fun inputStringToInputType(input: String): Params {
        val treeNode = TreeNode.fromNullableIntArray(input.toNullableIntArray())
        return Params(treeNode)
    }

    override fun algorithm(input: Params): DoubleArray = averageOfLevels(input.s)
    class Params(val s: TreeNode?)
}
