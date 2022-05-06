package solution

import Solution
import common.toIntArray

class Sol_1679_max_number_of_k_sum_pairs: Solution.General<Sol_1679_max_number_of_k_sum_pairs.Params, Int>() {
    /**
     * Solution 2
     * use pairs to count each number
     * Time: O(n) Space: O(n)
     */
    fun maxOperations(nums: IntArray, k: Int): Int {
        if (k==1) return 0
        val hashMap = HashMap<Int, Int>()
        nums.forEach { hashMap[it] = (hashMap[it]?:0) + 1 }
        var result = 0
        hashMap.keys.forEach { num ->
            val num1 = hashMap[num]?:0
            val num2 = hashMap[k-num]?:0
            val cnt = num1.coerceAtMost(num2)
            result += cnt
        }
        return result/2
    }

    /**
     * Solution 1
     * sort and two pointer
     * Time: O(nlogn) Space: O(1)
     */
//    fun maxOperations(nums: IntArray, k: Int): Int {
//        nums.sort()
//        var left = 0
//        var right = nums.size-1
//        var cnt = 0
//        while (left < right) {
//            if (nums[left] + nums[right] < k) left++
//            else if (nums[left] + nums[right] > k) right--
//            else {
//                cnt++
//                left++
//                right--
//            }
//        }
//        return cnt
//    }

    override val givenTestCases: Map<String, Int> = mapOf(
        "[1,2,3,4] 5" to 2,
        "[3,1,3,4,3] 6" to 1
    )
    override val customTestCases: Map<String, Int> = mapOf(
        "[2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2] 3" to 4
    )

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        val nums = split[0].toIntArray()
        val k = split[1].toInt()
        return Params(nums, k)
    }
    override fun algorithm(input: Params): Int= maxOperations(input.nums, input.k)
    class Params(val nums: IntArray, val k: Int)
}