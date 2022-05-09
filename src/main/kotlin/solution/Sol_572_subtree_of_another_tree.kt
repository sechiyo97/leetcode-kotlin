package solution

import Solution
import common.convertToString
import common.model.TreeNode
import common.toNullableIntArray

class Sol_572_subtree_of_another_tree: Solution.General<Sol_572_subtree_of_another_tree.Params, Boolean>() {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        root ?: return subRoot == null
        subRoot ?: return false

       if (root.`val` == subRoot.`val`) {
           val isSameTree = isSameTree(root, subRoot)
           if (isSameTree) return true
       }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
    }

    private fun isSameTree(node1: TreeNode?, node2: TreeNode?): Boolean {
        if (node1 == null) return node2 == null
        val leftCompare = isSameTree(node1.left, node2?.left)
        val rightCompare = isSameTree(node1.right, node2?.right)
        return node1.`val` == node2?.`val` && leftCompare && rightCompare
    }

    override val givenTestCases: Map<String, Boolean> = mapOf(
        "[3,4,5,1,2] [4,1,2]" to true,
        "[3,4,5,1,2,null,null,null,null,0] [4,1,2]" to false
    )
    override val customTestCases: Map<String, Boolean> = mapOf(
        "[1,1] [1]" to true,
        IntArray(10000000){1}.convertToString() + " [1,1,null,1,1,1,1,1,1]" to true
    )

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        val root = TreeNode.fromNullableIntArray(split[0].toNullableIntArray())
        val subRoot = TreeNode.fromNullableIntArray(split[1].toNullableIntArray())
        return Params(root, subRoot)
    }

    override fun algorithm(input: Params): Boolean = isSubtree(input.root, input.subRoot)
    class Params(val root: TreeNode?, val subRoot: TreeNode?)
}