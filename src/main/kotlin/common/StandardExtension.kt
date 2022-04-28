package common

fun <Type> Type.convertToString(): String {
    return when(this) {
        is IntArray -> this.contentToString()
        is BooleanArray -> this.contentToString()
        is FloatArray -> this.contentToString()
        is DoubleArray -> this.contentToString()
        is ByteArray -> this.contentToString()
        is CharArray -> this.contentToString()
        is LongArray -> this.contentToString()
        is ShortArray -> this.contentToString()
        is Array<*> -> '[' + this.joinToString { it.convertToString() } + ']'
        else -> this.toString()
    }
}

fun <Type> Type.checkContentEquals(other: Type): Boolean {
    return when(this) {
        is IntArray -> this.contentEquals(other as IntArray)
        is BooleanArray -> this.contentEquals(other as BooleanArray)
        is FloatArray -> this.contentEquals(other as FloatArray)
        is DoubleArray -> this.contentEquals(other as DoubleArray)
        is ByteArray -> this.contentEquals(other as ByteArray)
        is CharArray -> this.contentEquals(other as CharArray)
        is LongArray -> this.contentEquals(other as LongArray)
        is ShortArray -> this.contentEquals(other as ShortArray)
        is Array<*> -> this.indices.map { this[it].checkContentEquals((other as Array<*>)[it]) }.all { it }
        else -> this == other
    }
}

