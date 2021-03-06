package common.model

import common.convertToString

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    fun toIntArray(): IntArray {
        var curNode: ListNode? = this
        val list = mutableListOf<Int>()
        while (curNode != null) {
            list.add(curNode.`val`)
            curNode = curNode.next
        }
        return list.toIntArray()
    }

    override fun equals(other: Any?): Boolean {
        if (other is ListNode) {
            var curNode1: ListNode? = this
            var curNode2: ListNode? = other
            while (curNode1 != null && curNode2 != null) {
                if (curNode1.`val` != curNode2.`val`) return false
                curNode1 = curNode1.next
                curNode2 = curNode2.next
            }
            return curNode1 == null && curNode2 == null
        }
        else return false
    }

    override fun hashCode(): Int {
        var result = `val`
        result = 31 * result + (next?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return this.toIntArray().convertToString()
    }

    companion object {
        fun fromIntArray(array: IntArray): ListNode? {
            var index = 0
            var head: ListNode? = null
            var prev: ListNode? = null
            var cur: ListNode?
            while (index < array.size) {
                if (index == 0) {
                    head = ListNode(array[index])
                    prev = head
                }
                else {
                    cur = ListNode(array[index])
                    prev?.next = cur
                    prev = prev?.next
                }
                index++
            }
            return head
        }
    }
}
