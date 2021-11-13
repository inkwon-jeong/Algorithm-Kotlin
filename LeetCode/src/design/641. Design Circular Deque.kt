package designcirculardeque

class MyCircularDeque(private val k: Int) {

    private var size = 0
    private var start: Node? = null
    private var end: Node? = null

    fun insertFront(value: Int): Boolean {
        if (isFull()) return false
        val newNode = Node(value)
        if (isEmpty()) {
            start = newNode
            end = newNode
        } else {
            start?.prev = newNode
            newNode.next = start
            start = newNode
        }
        size++
        return true
    }

    fun insertLast(value: Int): Boolean {
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

    fun deleteFront(): Boolean {
        if (isEmpty()) return false
        start = start?.next
        start?.prev = null
        if (start == null) end = null
        size--
        return true
    }

    fun deleteLast(): Boolean {
        if (isEmpty()) return false
        end = end?.prev
        end?.next = null
        if (end == null) start = null
        size--
        return true
    }

    fun getFront(): Int {
        if (isEmpty()) return -1
        return start!!.n
    }

    fun getRear(): Int {
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
 * Your MyCircularDeque object will be instantiated and called as such:
 * var obj = MyCircularDeque(k)
 * var param_1 = obj.insertFront(value)
 * var param_2 = obj.insertLast(value)
 * var param_3 = obj.deleteFront()
 * var param_4 = obj.deleteLast()
 * var param_5 = obj.getFront()
 * var param_6 = obj.getRear()
 * var param_7 = obj.isEmpty()
 * var param_8 = obj.isFull()
 */