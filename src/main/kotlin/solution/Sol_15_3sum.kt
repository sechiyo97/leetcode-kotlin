package solution

import Solution
import common.toIntArray

// https://leetcode.com/problems/3sum/
class Sol_15_3sum: Solution.General<IntArray, List<List<Int>>>() {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        nums.sort() // sort for two-pointer solution

        var target = 0 // num #1
        val tripleMap = HashMap<Int, HashMap<Int, Int>>() // first-second-third tree

        while(target < nums.size-2 && nums[target] <= 0) {
            // get branch from (or add branch to) tripleMap
            var hashMap = tripleMap[nums[target]]
            if (hashMap == null) {
                hashMap = HashMap()
                tripleMap[nums[target]] = hashMap
            }

            // two-pointer solution for num #2 and num #3 (num #1 + num #2 + num #3 == 0)
            var left = target + 1
            var right = nums.size - 1
            while (left < right) {
                val sum = nums[target]+nums[left]+nums[right]
                when {
                    sum < 0 -> left++
                    sum > 0 -> right--
                    else -> {
                        if (hashMap[nums[left]] == null) hashMap[nums[left]] = nums[right]
                        left++
                        right--
                    }
                }
            }
            target++
            while (target < nums.size-2 && nums[target] <= 0 && nums[target-1] == nums[target+1]) target++
        }

        // add results
        tripleMap.forEach { num1, hashMap ->
            result.addAll(hashMap.map { (key, value) -> listOf(num1, key, value) })
        }
        return result
    }

    override val givenTestCases: Map<String, List<List<Int>>> = mapOf(
        "[-1,0,1,2,-1,-4]" to listOf(listOf(-1,-1,2), listOf(-1,0,1)),
        "[]" to listOf(),
        "[0]" to listOf()
    )
    override val customTestCases: Map<String, List<List<Int>>> = mapOf(
        "[3,0,-2,-1,1,2]" to listOf(listOf(-2,-1,3), listOf(-2,0,2), listOf(-1,0,1)),
        "[-1,0,1,2,-1,-4]" to listOf(listOf(-1,-1,2), listOf(-1,0,1)),
        "[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]" to listOf(listOf(0,0,0))
    )

    override fun inputStringToInputType(input: String): IntArray = input.toIntArray()
    override fun algorithm(input: IntArray): List<List<Int>> = threeSum(input)
}