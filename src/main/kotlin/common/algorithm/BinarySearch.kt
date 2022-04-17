package common.algorithm

fun binarySearch(nums: IntArray, target: Int): Int {
    var min = 0
    var max = nums.lastIndex
    var mid = (min + max)/2
    while (max >= min) {
        when {
            target > nums[mid] -> min = mid + 1
            target < nums[mid] -> max = mid - 1
            else -> return mid
        }
        mid = (min/2.0 + max/2.0).toInt()
    }
    return -1
}