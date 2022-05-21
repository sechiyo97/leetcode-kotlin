package solution

import common.convertToString
import common.toIntArray

class Sol_322_coin_change: Solution.General<Sol_322_coin_change.Params, Int>() {
    fun coinChange(coins: IntArray, amount: Int): Int {
        if (amount == 0) return 0

        val coinChanges = IntArray(10000)

        coins.forEach {
            if (it < coinChanges.size) coinChanges[it] = 1
        }

        for(i in 0 until amount+1) fillCoinChanges(coins, coinChanges, i)
        return if (coinChanges[amount] > 0) coinChanges[amount] else -1
    }

    private fun fillCoinChanges(coins: IntArray, coinChanges: IntArray, target: Int) {
        if (coinChanges[target] > 0) return

        coins.forEach {
            if (target > it) {
                if (coinChanges[target-it] > 0) {
                    val sum = coinChanges[target-it] + 1
                    if (coinChanges[target] == 0 || coinChanges[target] > sum) coinChanges[target] = sum
                }
            }
        }
    }

    override val givenTestCases: Map<String, Int> = mapOf(
        "[1,2,5] 11" to 3,
        "[2] 3" to -1,
        "[1] 0" to 0
    )
    override val customTestCases: Map<String, Int> = mapOf(
        "[186,419,83,408] 6249" to 20,
        "[411,412,413,414,415,416,417,418,419,420,421,422] 9864" to 24,
        "[1] 2" to 2,
        "[2147483647] 2" to -1
    )

    override fun algorithm(input: Params): Int = coinChange(input.coins, input.amount)
    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        val coins = split[0].toIntArray()
        val amount = split[1].toInt()
        return Params(coins, amount)
    }
    class Params(val coins: IntArray, val amount: Int)
}