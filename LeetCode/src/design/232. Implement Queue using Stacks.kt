package implementqueueusingstacks

import java.util.*

class MyQueue() {

    /** Initialize your data structure here. */
    private val data = Stack<Int>()
    private val temp = Stack<Int>()

    /** Push element x to the back of queue. */
    fun push(x: Int) {
        while (!data.isEmpty())
            temp.push(data.pop())

        data.push(x)

        while (!temp.isEmpty())
            data.push(temp.pop())
    }

    /** Removes the element from in front of queue and returns that element. */
    fun pop(): Int {
        return data.pop()
    }

    /** Get the front element. */
    fun peek(): Int {
        return data.peek()
    }

    /** Returns whether the queue is empty. */
    fun empty(): Boolean {
        return data.isEmpty()
    }

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */

