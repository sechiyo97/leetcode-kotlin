package common

fun IntArray.swap(first: Int, second: Int) { this[first] = this[second].also { this[second] = this[first] } }

fun String.toIntArray(): IntArray {
    val exceptParenthesis = this.removePrefix("[").removeSuffix("]")
    return exceptParenthesis.split(",").mapNotNull { it.trim().toIntOrNull() }.toIntArray()
}
fun String.toDoubleArray(): DoubleArray {
    val exceptParenthesis = this.removePrefix("[").removeSuffix("]")
    return exceptParenthesis.split(",").mapNotNull { it.trim().toDoubleOrNull() }.toDoubleArray()
}
fun String.toNullableIntArray(): Array<Int?> {
    val exceptParenthesis = this.removePrefix("[").removeSuffix("]")
    return exceptParenthesis.split(",").map { it.trim().toIntOrNull() }.toTypedArray()
}
fun String.toStringArray(): Array<String> {
    val exceptParenthesis = this.trim().removePrefix("[").removeSuffix("]").replace("\"", "")
    return exceptParenthesis.split(',').toTypedArray()
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
fun String.to2DCharArray(): Array<CharArray> {
    val exceptParenthesis = this.removePrefix("[").removeSuffix("]")
    return exceptParenthesis.split(',').map { it.toCharArray() }.toTypedArray()
}
fun String.to2DStringArray(): Array<Array<String>> {
    val exceptParenthesis = this.removePrefix("[").removeSuffix("]")
    return exceptParenthesis.split(",[").map { it.toStringArray() }.toTypedArray()
}
