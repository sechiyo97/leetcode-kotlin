package solution

import Solution
import common.model.ListNode
import common.toIntArray

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
class Sol_19_remove_nth_node_from_end_of_list: Solution.General<Sol_19_remove_nth_node_from_end_of_list.Params, ListNode?>(){
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummy = ListNode(0).apply { next = head }
        var left: ListNode? = dummy
        var right: ListNode? = dummy
        for (i in 0..n) right = right?.next

        while(right != null) {
            left = left?.next
            right = right.next
        }

        left?.next = left?.next?.next
        return dummy.next
    }

    override val givenTestCases: Map<String, ListNode?> = mapOf(
        "[1,2,3,4,5] 2" to ListNode.fromIntArray(intArrayOf(1,2,3,5)),
        "[1] 1" to ListNode.fromIntArray(intArrayOf()),
        "[1,2] 1" to ListNode.fromIntArray(intArrayOf(1))
    )

    override fun algorithm(input: Params): ListNode? = removeNthFromEnd(input.head, input.n)
    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        val head = ListNode.fromIntArray(split[0].toIntArray())
        val n = split[1].toInt()
        return Params(head, n)
    }
    class Params(val head: ListNode?, val n: Int)
}


