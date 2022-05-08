package solution

// https://leetcode.com/problems/flatten-nested-list-iterator/
private class NestedIterator(nestedList: List<NestedInteger>) {
    var flat = nestedList.flatMap { it.flatten() }
    var index = -1
    fun next(): Int {
        index++
        return flat[index]
    }

    fun hasNext(): Boolean {
        return index == flat.size-1
    }

    private fun NestedInteger.flatten(): List<Int> {
        val result: MutableList<Int> = mutableListOf()
        if (this.isInteger()) result.add(this.getInteger()!!)
        else {
            this.getList()?.forEach {
                result.addAll(it.flatten())
            }
        }
        return result
    }

}

private abstract class NestedInteger {
    // Constructor initializes an empty nested list.
    constructor()

    // Constructor initializes a single integer.
    constructor(value: Int)

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    abstract fun isInteger(): Boolean

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    abstract fun getInteger(): Int?

    // Set this NestedInteger to hold a single integer.
    abstract fun setInteger(value: Int): Unit

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    abstract fun add(ni: NestedInteger): Unit

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    abstract fun getList(): List<NestedInteger>?
}