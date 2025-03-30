package solution

import Solution
import common.toIntArray

// https://leetcode.com/problems/apply-operations-to-maximize-score/
class Sol_2818_apply_operations_to_maximize_score: Solution.General<Sol_2818_apply_operations_to_maximize_score.Params, Int>() {
    fun maximumScore(nums: List<Int>, k: Int): Int {
        val mod = 1_000_000_007

        val n = nums.size
        var remaining = k

        val maxVal = nums.maxOrNull() ?: 0
        val spf = buildSPF(maxVal)
        val primeScores = nums.map { countDistinctPrimeFactors(it, spf) }

        val left = IntArray(n) { -1 }
        val right = IntArray(n) { n }
        val stack = ArrayDeque<Int>()

        for (i in n - 1 downTo 0) {
            while (stack.isNotEmpty() && primeScores[stack.last()] <= primeScores[i]) {
                left[stack.removeLast()] = i
            }
            stack.addLast(i)
        }

        stack.clear()

        for (i in 0 until n) {
            while (stack.isNotEmpty() && primeScores[stack.last()] < primeScores[i]) {
                right[stack.removeLast()] = i
            }
            stack.addLast(i)
        }

        val sortedIndices = nums.indices.sortedWith(
            compareByDescending<Int> { nums[it] }.thenBy { it }
        )

        var result = 1L

        for (i in sortedIndices) {
            val rangeCount = (i - left[i]).toLong() * (right[i] - i)
            val useCount = minOf(remaining.toLong(), rangeCount)
            result = (result * modPow(nums[i].toLong(), useCount, mod)) % mod
            remaining -= useCount.toInt()
            if (remaining == 0) break
        }

        return result.toInt()
    }

    private fun countDistinctPrimeFactors(n: Int, spf: IntArray): Int {
        var x = n
        val primes = mutableSetOf<Int>()
        while (x > 1) {
            val p = spf[x]
            primes += p
            while (x % p == 0) x /= p
        }
        return primes.size
    }

    private fun buildSPF(n: Int): IntArray {
        val spf = IntArray(n + 1) { it }
        for (i in 2..n) {
            if (spf[i] == i) {
                var j = i * 2
                while (j <= n) {
                    spf[j] = minOf(spf[j], i)
                    j += i
                }
            }
        }
        return spf
    }

    private fun modPow(base: Long, exp: Long, mod: Int): Long {
        var res = 1L
        var b = base % mod
        var e = exp
        while (e > 0) {
            if (e % 2 == 1L) res = (res * b) % mod
            b = (b * b) % mod
            e /= 2
        }
        return res
    }

    override val givenTestCases: Map<String, Int> = mapOf(
        "[8,3,9,3,8] 2" to 81,
        "[19,12,14,6,10,18] 3" to 4788,
    )

    override val customTestCases: Map<String, Int> = mapOf(
    )

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        val nums = split[0].toIntArray()
        val k = split[1].toInt()
        return Params(nums, k)
    }
    override fun algorithm(input: Params): Int= maximumScore(input.nums.toList(), input.k)
    class Params(val nums: IntArray, val k: Int)
}