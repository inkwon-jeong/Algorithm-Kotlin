package flattennestedlistiterator

import java.util.*

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * class NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     constructor()
 *
 *     // Constructor initializes a single integer.
 *     constructor(value: Int)
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     fun isInteger(): Boolean
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     fun getInteger(): Int?
 *
 *     // Set this NestedInteger to hold a single integer.
 *     fun setInteger(value: Int): Unit
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     fun add(ni: NestedInteger): Unit
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     fun getList(): List<NestedInteger>?
 * }
 */

class NestedIterator(nestedList: List<NestedInteger>) {

    private val queue: Queue<Int> = LinkedList()

    init {
        nestedList.forEach { nestedInteger ->
            queue.addAll(getAll(nestedInteger))
        }
    }

    fun next(): Int {
        return queue.poll()
    }

    private fun getAll(nestedInteger: NestedInteger): List<Int> {
        val list = mutableListOf<Int>()
        if (nestedInteger.isInteger())
            nestedInteger.getInteger()?.let { list.add(it) }
        else {
            nestedInteger.getList()?.forEach {
                list.addAll(getAll(it))
            }
        }
        return list
    }

    fun hasNext(): Boolean {
        return queue.isNotEmpty()
    }
}

interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    fun isInteger(): Boolean

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    fun getInteger(): Int?

    // Set this NestedInteger to hold a single integer.
    fun setInteger(value: Int): Unit

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    fun add(ni: NestedInteger): Unit

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    fun getList(): List<NestedInteger>?
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * var obj = NestedIterator(nestedList)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */

