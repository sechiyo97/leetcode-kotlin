package solution

import Solution
import common.model.ListNode
import common.toIntArray

class Sol_2_add_two_numbers: Solution.General<Sol_2_add_two_numbers.Params, ListNode?>() {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummy = ListNode(-1)
        var cur: ListNode? = dummy

        var node1 = l1
        var node2 = l2
        var carry = 0
        while (node1 != null || node2 != null) {
            var sum = (node1?.`val`?:0) + (node2?.`val`?:0) + carry
            if (sum >= 10) {
                carry = 1
                sum-=10
            } else carry = 0
            cur?.next = ListNode(sum)
            node1 = node1?.next
            node2 = node2?.next
            cur = cur?.next
        }
        if (carry == 1) cur?.next = ListNode(1)
        return dummy.next
    }

    override val givenTestCases: Map<String, ListNode?> = mapOf(
        "[2,4,3] [5,6,4]" to ListNode.fromIntArray("[7,0,8]".toIntArray()),
        "[0] [0]" to ListNode.fromIntArray("[0]".toIntArray()),
        "[9,9,9,9,9,9,9] [9,9,9,9]" to ListNode.fromIntArray("[8,9,9,9,0,0,0,1]".toIntArray())
    )

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        val l1 = ListNode.fromIntArray(split[0].toIntArray())
        val l2 = ListNode.fromIntArray(split[1].toIntArray())
        return Params(l1, l2)
    }
    override fun algorithm(input: Params): ListNode? = addTwoNumbers(input.l1, input.l2)
    class Params(val l1: ListNode?, val l2: ListNode?)
}