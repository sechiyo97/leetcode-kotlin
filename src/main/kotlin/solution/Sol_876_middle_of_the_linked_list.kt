package solution

import Solution
import common.model.ListNode
import common.model.toHeadListNode
import common.toIntArray

class Sol_876_middle_of_the_linked_list: Solution.General<ListNode?, ListNode?>(){
    override val givenTestCases: Map<String, ListNode?> = mapOf(
        "[1,2,3,4,5]" to intArrayOf(3,4,5).toHeadListNode(),
        "[1,2,3,4,5,6]" to intArrayOf(4,5,6).toHeadListNode()
    )

    override fun algorithm(input: ListNode?): ListNode? {
        val head = input

        var currentNode: ListNode? = head
        val list = mutableListOf<ListNode>()
        var size = 0
        while (currentNode != null) {
            size++
            list.add(currentNode)
            currentNode = currentNode.next
        }
        return list[size/2]
    }

    override fun inputStringToInputType(input: String): ListNode? {
        val heads = input.toIntArray()

        var currentNode: ListNode? = ListNode(0)
        val headNode = currentNode
        heads.forEachIndexed { index, value ->
            currentNode?.`val` = value
            val nextNode = if (index == heads.lastIndex) null else ListNode(0)
            currentNode?.next = nextNode
            currentNode = nextNode
        }
        return headNode
    }

}

