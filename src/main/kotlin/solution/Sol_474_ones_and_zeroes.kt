package solution

class Sol_474_ones_and_zeroes: Solution.General<Sol_474_ones_and_zeroes.Params, Int>() {
    fun findMaxForm(strs: Array<String>, m: Int, n: Int): Int {
        // create 2d array to record maximum subset sizes
        val maxForms = Array(m+1){ IntArray(n+1) }
        strs.forEach { str ->
            // count ones and zeros of the string
            var oneCnt = 0
            var zeroCnt = 0
            str.forEach { char ->
                if (char == '0') zeroCnt++
                else oneCnt++
            }
            // dp: fill maxForm values where indices are related to current string
            var zeroIdx = m
            while (zeroIdx >= zeroCnt) {
                var oneIdx = n
                while (oneIdx >= oneCnt) {
                    maxForms[zeroIdx][oneIdx] = maxForms[zeroIdx][oneIdx]
                        .coerceAtLeast(maxForms[zeroIdx - zeroCnt][oneIdx - oneCnt] + 1)
                    oneIdx--
                }
                zeroIdx--
            }
        }
        return maxForms[m][n]
    }

    override val givenTestCases: Map<String, Int> = mapOf(
        "10,0001,111001,1,0 5 3" to 4,
        "10,0,1 1 1" to 2
    )

    override fun inputStringToInputType(input: String): Params {
        val split = input.split(' ')
        val strs = split[0].split(',').toTypedArray()
        val m = split[1].toInt()
        val n = split[2].toInt()
        return Params(strs, m, n)
    }

    override fun algorithm(input: Params): Int = findMaxForm(input.strs, input.m, input.n)
    class Params(val strs: Array<String>, val m: Int, val n: Int)
}