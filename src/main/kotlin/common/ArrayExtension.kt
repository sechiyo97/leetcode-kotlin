package common

import java.lang.StringBuilder

fun IntArray.swap(first: Int, second: Int) { this[first] = this[second].also { this[second] = this[first] } }

fun String.toIntArray(): IntArray {
    val exceptParenthesis = this.removePrefix("[").removeSuffix("]")
    return exceptParenthesis.split(",").map { it.trim().toInt() }.toIntArray()
}

fun String.to2DIntArray(): Array<IntArray> {
    val exceptParenthesis = this.removePrefix("[").removeSuffix("]")
    val resultList = mutableListOf<IntArray>()
    val curString = StringBuilder()
    exceptParenthesis.forEach {
        when (it) {
            '[' -> curString.clear()
            ']' -> resultList.add(curString.toString().toIntArray())
            else -> curString.append(it)
        }
    }
    val resultArray = Array(resultList.size) { IntArray(0) }
    resultList.forEachIndexed { index, ints ->
        resultArray[index] = ints
    }
    return resultArray
}
