package solution

import Solution
import common.model.TreeNode
import common.model.toHeadListNode
import common.model.toRootTreeNode
import common.toIntArray
import common.toNullableIntArray

class Sol_617_merge_two_binary_trees: Solution.General<Sol_617_merge_two_binary_trees.Params, TreeNode?>() {
    data class Params(val root1: TreeNode?, val root2: TreeNode?)

    override val givenTestCases: Map<String, TreeNode?> = mapOf(
        "[1,2,3,5] [2,1,3,null,4,null,7]" to "[3,4,5,5,4,null,7]".toNullableIntArray().toRootTreeNode(),
        "[1] [1,2]" to "[2,2]".toNullableIntArray().toRootTreeNode()
    )

    override fun algorithm(input: Params): TreeNode? {
        val root1 = input.root1
        val root2 = input.root2

        return root1
    }

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        val root1 = split[0].toNullableIntArray().toRootTreeNode()
        val root2 = split[1].toNullableIntArray().toRootTreeNode()
        return Params(root1, root2)
    }
}