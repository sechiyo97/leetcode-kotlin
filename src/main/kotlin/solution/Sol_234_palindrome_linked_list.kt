package solution

import Solution
import common.model.ListNode
import common.toIntArray

// https://leetcode.com/problems/palindrome-linked-list/
class Sol_234_palindrome_linked_list: Solution.General<ListNode?, Boolean>(){
    fun isPalindrome(head: ListNode?): Boolean {
        var currentNode: ListNode? = head
        val list = mutableListOf<Int>()
        var size = 0
        while (currentNode != null) {
            size++
            val value = currentNode.`val`
            list.add(value)
            currentNode = currentNode.next
        }
        var forwardIndex = 0
        var backwardIndex = size - 1
        for (i in 0 until size/2) {
            if (list[forwardIndex] != list[backwardIndex]) return false
            else {
                forwardIndex++
                backwardIndex--
            }
        }
        return true
    }

    override val givenTestCases: Map<String, Boolean> = mapOf(
        "[1,2,2,1]" to true,
        "[1,2]" to false
    )
    override val customTestCases: Map<String, Boolean> = mapOf(
        "[1,2,3,2,3,2,1]" to true
    )

    override fun algorithm(input: ListNode?): Boolean = isPalindrome(input)
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


