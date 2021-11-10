package designcircularqueue

class MyCircularQueue(private val k: Int) {

    private var size = 0
    private var start: Node? = null
    private var end: Node? = null

    fun enQueue(value: Int): Boolean {
        if (isFull()) return false
        val newNode = Node(value)
        if (isEmpty()) {
            start = newNode
            end = newNode
        } else {
            end?.next = newNode
            newNode.prev = end
            end = newNode
        }
        size++
        return true
    }

    fun deQueue(): Boolean {
        if (isEmpty()) return false
        start = start?.next
        start?.prev = null
        if (start == null) end = null
        size--
        return true
    }

    fun Front(): Int {
        if (isEmpty()) return -1
        return start!!.n
    }

    fun Rear(): Int {
        if (isEmpty()) return -1
        return end!!.n
    }

    fun isEmpty() = size == 0

    fun isFull() = size == k

    class Node(val n: Int) {
        var prev: Node? = null
        var next: Node? = null
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * var obj = MyCircularQueue(k)
 * var param_1 = obj.enQueue(value)
 * var param_2 = obj.deQueue()
 * var param_3 = obj.Front()
 * var param_4 = obj.Rear()
 * var param_5 = obj.isEmpty()
 * var param_6 = obj.isFull()
 */

