package solution

import Solution
import common.model.ListNode
import common.toIntArray

// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
class Sol_82_remove_duplicates_from_sorted_list_ii: Solution.General<ListNode?, ListNode?>() {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        val dummy = ListNode(-101).apply { next = head }
        var prevNode: ListNode? = dummy
        var curNode: ListNode? = head
        while (curNode?.next != null) {
            val isDuplicate = curNode.`val` == curNode.next?.`val`
            if (isDuplicate) {
                while (curNode?.`val` == curNode?.next?.`val`) curNode = curNode?.next
                prevNode?.next = curNode?.next
            } else {
                prevNode = curNode
            }
            curNode = curNode?.next
        }
        return dummy.next
    }

    override val givenTestCases: Map<String, ListNode?> = mapOf(
        "[1,2,3,3,4,4,5]" to ListNode.fromIntArray("[1,2,5]".toIntArray()),
        "[1.1.1,2,3]" to ListNode.fromIntArray("[2,3]".toIntArray())
    )

    override fun inputStringToInputType(input: String): ListNode? = ListNode.fromIntArray(input.toIntArray())
    override fun algorithm(input: ListNode?): ListNode? = deleteDuplicates(input)

}