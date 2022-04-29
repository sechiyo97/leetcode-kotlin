package solution

import common.model.ListNode
import common.toIntArray

class Sol_206_reverse_linked_list: Solution.General<ListNode?, ListNode?>() {
    override val givenTestCases: Map<String, ListNode?> = mapOf(
        "[1,2,3,4,5]" to ListNode.fromIntArray("[5,4,3,2,1]".toIntArray()),
        "[1,2]" to ListNode.fromIntArray("[2,1]".toIntArray()),
        "[]" to ListNode.fromIntArray("[]".toIntArray())
    )

    override fun algorithm(input: ListNode?): ListNode? {
        val head = input

        var prev: ListNode? = null
        var cur: ListNode? = head

        while(cur != null) {
            val orgNext = cur.next
            cur.next = prev
            prev = cur
            cur = orgNext
        }
        return prev
    }

    override fun inputStringToInputType(input: String): ListNode? {
        return ListNode.fromIntArray(input.toIntArray())
    }
}