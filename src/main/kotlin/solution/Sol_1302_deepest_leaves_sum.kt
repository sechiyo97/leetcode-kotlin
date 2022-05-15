package solution

import Solution
import common.model.TreeNode
import common.toNullableIntArray
import java.util.*

class Sol_1302_deepest_leaves_sum: Solution.General<TreeNode?, Int>() {
    fun deepestLeavesSum(root: TreeNode?): Int {
        var sum = 0
        val queue: Queue<TreeNode> = LinkedList()

        queue.offer(root!!)
        while(queue.isNotEmpty()) {
            sum = 0
            for (i in queue.indices) {
                val node = queue.poll()
                sum += node.`val`
                if (node.left != null) queue.offer(node.left!!)
                if (node.right != null) queue.offer(node.right!!)
            }
        }
        return sum
    }

    override val givenTestCases: Map<String, Int> = mapOf(
        "[1,2,3,4,5,null,6,7,null,null,null,null,null,8]" to 15,
        "[6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]" to 19
    )

    override fun inputStringToInputType(input: String): TreeNode? = TreeNode.fromNullableIntArray(input.toNullableIntArray())
    override fun algorithm(input: TreeNode?): Int = deepestLeavesSum(input)
}