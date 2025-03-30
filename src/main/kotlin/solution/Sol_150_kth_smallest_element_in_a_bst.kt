package solution

import Solution
import common.model.TreeNode
import common.toNullableIntArray


// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
class Sol_150_kth_smallest_element_in_a_bst: Solution.General<Sol_150_kth_smallest_element_in_a_bst.Params, Int>() {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        val list = mutableListOf<Int>()
        inorderFill(root, list)
        return list[k-1]
    }

    private fun inorderFill(root: TreeNode?, list: MutableList<Int>) {
        if (root == null) return
        inorderFill(root.left, list)
        list.add(root.`val`)
        inorderFill(root.right, list)
    }

    override val givenTestCases: Map<String, Int> = mapOf(
        "[3,1,4,null,2] 1" to 1,
        "[5,3,6,2,4,null,null,1] 3" to 3,
    )

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        val root = TreeNode.fromNullableIntArray(split[0].toNullableIntArray())
        val k = split[1].toInt()
        return Params(root, k)
    }
    override fun algorithm(input: Params): Int = kthSmallest(input.root, input.k)
    class Params(val root: TreeNode?, val k: Int)

}