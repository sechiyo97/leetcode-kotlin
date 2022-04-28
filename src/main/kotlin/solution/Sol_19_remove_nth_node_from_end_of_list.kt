package solution

import Solution
import common.model.ListNode
import common.model.toHeadListNode
import common.toIntArray

class Sol_19_remove_nth_node_from_end_of_list: Solution.General<Sol_19_remove_nth_node_from_end_of_list.Params, ListNode?>(){
    data class Params(val head: ListNode?, val n: Int)

    override val givenTestCases: Map<String, ListNode?> = mapOf(
        "[1,2,3,4,5] 2" to intArrayOf(1,2,3,5).toHeadListNode(),
        "[1] 1" to intArrayOf().toHeadListNode(),
        "[1,2] 1" to intArrayOf(1).toHeadListNode()
    )

    override fun algorithm(input: Params): ListNode? {
        val head = input.head
        val n = input.n

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

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        val head = split[0].toIntArray().toHeadListNode()
        val n = split[1].toInt()
        return Params(head, n)
    }
}


