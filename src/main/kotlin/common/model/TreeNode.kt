package common.model

import common.convertToString

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    val depth get(): Int {
        return 0
    }

    fun toIntArray(): IntArray {
        return IntArray(0)
    }

    override fun equals(other: Any?): Boolean {
        return false
    }

    override fun toString(): String {
        return this.toIntArray().convertToString()
    }

    override fun hashCode(): Int {
        var result = `val`
        result = 31 * result + (left?.hashCode() ?: 0)
        result = 31 * result + (right?.hashCode() ?: 0)
        return result
    }
}

fun IntArray.toRootTreeNode(): TreeNode? {
    return null
}