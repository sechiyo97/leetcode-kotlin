package solution

import Solution
import common.model.TreeNode
import common.toIntArray
import common.toNullableIntArray

// FIXME
// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
class Sol_108_convert_sorted_array_to_binary_search_tree: Solution.General<Sol_108_convert_sorted_array_to_binary_search_tree.Params, TreeNode?>() {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        if (nums.isEmpty()) return null
        return divided(nums, 0, nums.lastIndex)
    }

    private fun divided(nums: IntArray, start: Int, end: Int): TreeNode? {
        if (start > end) return null

        val mid = start + (end-start)/2
        val root = TreeNode(nums[mid])
        root.left = divided(nums, start, mid - 1)
        root.right = divided(nums, mid + 1, end)
        return root
    }

    // FIXME: currently, 2/4 is success since there are multiple answers. testCase logic with multiple answers should be upgraded later.
    override val givenTestCases: Map<String, TreeNode?> = mapOf(
//        "[-10,-3,0,5,9]" to TreeNode.fromNullableIntArray("[0,-3,9,-10,null,5]".toNullableIntArray()),
        "[-10,-3,0,5,9]" to TreeNode.fromNullableIntArray("[0,-10,5,null,-3,null,9]".toNullableIntArray()),
//        "[1,3]" to TreeNode.fromNullableIntArray("[3,1]".toNullableIntArray()),
        "[1,3]" to TreeNode.fromNullableIntArray("[1,null,3]".toNullableIntArray()),
    )

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        val nums = split[0].toIntArray()
        return Params(nums)
    }
    override fun algorithm(input: Params): TreeNode? = sortedArrayToBST(input.nums)
    class Params(val nums: IntArray)

}