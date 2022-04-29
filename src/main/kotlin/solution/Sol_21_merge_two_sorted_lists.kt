package solution

import Solution
import common.model.ListNode
import common.toIntArray

class Sol_21_merge_two_sorted_lists: Solution.General<Sol_21_merge_two_sorted_lists.Params, ListNode?>() {
    data class Params(val list1: ListNode?, val list2: ListNode?)

    override val givenTestCases: Map<String, ListNode?> = mapOf(
        "[1,2,4] [1,3,4]" to ListNode.fromIntArray(intArrayOf(1,1,2,3,4,4)),
        "[] []" to null,
        "[] [0]" to ListNode.fromIntArray(intArrayOf(0))
    )

    override fun algorithm(input: Params): ListNode? {
        return input.list1
    }

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        val list1 = ListNode.fromIntArray(split[0].toIntArray())
        val list2 = ListNode.fromIntArray(split[1].toIntArray())
        return Params(list1, list2)
    }
}