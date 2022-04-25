package solution

import Solution

class Solution278_FirstBadVersion: Solution.General<Solution278_FirstBadVersion.Params, Int>() {
    class Params(val n: Int, val bad: Int)

    override val givenTestCases: Map<String, Int> = mapOf(
        "5 4" to 4,
        "1 1" to 1
    )
    override val customTestCases: Map<String, Int> = mapOf(
        "6 5" to 5
    )

    private class Versions (
        val versionCount: Int,
        val firstBadVersion: Int
    ) {
        fun isBadVersion(version: Int) = version >= firstBadVersion
    }

    override fun algorithm(input: Params): Int {
        val n = input.n
        val bad = input.bad

        val versions = Versions(n, bad)

        var min = 0
        var max = n-1
        var mid = (min/2.0 + max/2.0).toInt()
        while (min < max) {
            if (versions.isBadVersion(mid+1))
                max = mid
            else
                min = mid + 1
            mid = (min/2.0 + max/2.0).toInt()
        }
        return mid+1
    }

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(" ")
        return Params(split[0].toInt(), split[1].toInt())
    }
}
