package solution

import Solution
import common.to2DIntArray

// https://leetcode.com/problems/richest-customer-wealth/
class Sol_1672_richest_customer_wealth: Solution.General<Array<IntArray>, Int>() {
    fun maximumWealth(accounts: Array<IntArray>): Int {
        return accounts.map { it.sum() }.sorted().last()
    }

    override val givenTestCases = mapOf(
        "[[1,2,3],[3,2,1]]" to 6,
        "[[1,5],[7,3],[3,5]]" to 10,
        "[[2,8,7],[7,1,3],[1,9,5]" to 17
    )

    override fun algorithm(input: Array<IntArray>): Int  = maximumWealth(input)
    override fun inputStringToInputType(input: String): Array<IntArray> {
        return input.to2DIntArray()
    }
}
