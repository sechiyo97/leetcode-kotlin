package solution

import Solution
import common.model.ListNode
import common.toIntArray

// https://leetcode.com/problems/middle-of-the-linked-list/
class Sol_876_middle_of_the_linked_list: Solution.General<ListNode?, ListNode?>(){
    fun middleNode(head: ListNode?): ListNode? {
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

    override val givenTestCases: Map<String, ListNode?> = mapOf(
        "[1,2,3,4,5]" to ListNode.fromIntArray(intArrayOf(3,4,5)),
        "[1,2,3,4,5,6]" to ListNode.fromIntArray(intArrayOf(4,5,6))
    )

    override fun algorithm(input: ListNode?): ListNode? = middleNode(input)
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


