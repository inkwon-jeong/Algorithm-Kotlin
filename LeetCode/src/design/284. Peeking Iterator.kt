package peekingiterator

// Kotlin Iterator reference:
// https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterator/

class PeekingIterator(val iterator: Iterator<Int>) : Iterator<Int> {

    private var top: Int? = null

    init {
        if (iterator.hasNext())
            top = iterator.next()
    }

    fun peek() = top ?: throw Exception()

    override fun next(): Int {
        val next = top ?: throw Exception()
        top =
            if (iterator.hasNext()) iterator.next()
            else null

        return next
    }

    override fun hasNext() = top != null
}

/**
 * Your PeekingIterator object will be instantiated and called as such:
 * var obj = PeekingIterator(arr)
 * var param_1 = obj.next()
 * var param_2 = obj.peek()
 * var param_3 = obj.hasNext()
 */

