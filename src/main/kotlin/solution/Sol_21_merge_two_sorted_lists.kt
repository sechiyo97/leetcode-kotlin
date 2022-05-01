package solution

import Solution
import common.model.ListNode
import common.toIntArray

// https://leetcode.com/problems/merge-two-sorted-lists/
class Sol_21_merge_two_sorted_lists: Solution.General<Sol_21_merge_two_sorted_lists.Params, ListNode?>() {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var node1 = list1
        var node2 = list2

        val dummyResult = ListNode(-1)
        var nodeResult: ListNode? = dummyResult

        while (node1 != null && node2 != null) {
            if(node1.`val` > node2.`val`) {
                nodeResult?.next = node2
                node2 = node2.next
            } else {
                nodeResult?.next = node1
                node1 = node1.next
            }
            nodeResult = nodeResult?.next
        }
        nodeResult?.next = node1 ?: node2

        return dummyResult.next
    }


    override val givenTestCases: Map<String, ListNode?> = mapOf(
        "[1,2,4] [1,3,4]" to ListNode.fromIntArray(intArrayOf(1,1,2,3,4,4)),
        "[] []" to null,
        "[] [0]" to ListNode.fromIntArray(intArrayOf(0))
    )
    override val customTestCases: Map<String, ListNode?> = mapOf(
        "[1] []" to ListNode.fromIntArray(intArrayOf(1))
    )

    override fun algorithm(input: Params): ListNode? = mergeTwoLists(input.list1, input.list2)
    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        val list1 = ListNode.fromIntArray(split[0].toIntArray())
        val list2 = ListNode.fromIntArray(split[1].toIntArray())
        return Params(list1, list2)
    }
    class Params(val list1: ListNode?, val list2: ListNode?)
}