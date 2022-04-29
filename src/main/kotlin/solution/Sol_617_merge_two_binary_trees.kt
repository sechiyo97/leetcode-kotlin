package solution

import Solution
import common.model.TreeNode
import common.toNullableIntArray

class Sol_617_merge_two_binary_trees: Solution.General<Sol_617_merge_two_binary_trees.Params, TreeNode?>() {
    data class Params(val root1: TreeNode?, val root2: TreeNode?)

    override val givenTestCases: Map<String, TreeNode?> = mapOf(
        "[1,3,2,5] [2,1,3,null,4,null,7]" to TreeNode.fromNullableIntArray(arrayOf(3,4,5,5,4,null,7)),
        "[1] [1,2]" to TreeNode.fromNullableIntArray(arrayOf(2,2))
    )
    override val customTestCases: Map<String, TreeNode?> = mapOf(
        "[] [1]" to TreeNode.fromNullableIntArray(arrayOf(1))
    )

    override fun algorithm(input: Params): TreeNode? {
        val root1 = input.root1
        val root2 = input.root2

        return if (root1 != null) {
            root1.addTree(root2)
            root1
        } else root2
    }

    private fun TreeNode.addTree(other: TreeNode?) {
        this.`val` += other?.`val` ?: 0

        val thisLeft = this.left
        val otherLeft = other?.left
        if (thisLeft != null) thisLeft.addTree(otherLeft)
        else if (otherLeft != null) this.left = otherLeft

        val otherRight = other?.right
        val thisRight = this.right
        if (thisRight != null) thisRight.addTree(otherRight)
        else if (otherRight != null) this.right = otherRight
    }

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        val root1 = TreeNode.fromNullableIntArray(split[0].toNullableIntArray())
        val root2 = TreeNode.fromNullableIntArray(split[1].toNullableIntArray())
        return Params(root1, root2)
    }
}