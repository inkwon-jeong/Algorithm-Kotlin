package implementstackusingqueues

import java.util.*

class MyStack() {

    /** Initialize your data structure here. */
    private val data: Queue<Int> = LinkedList()
    private val temp: Queue<Int> = LinkedList()

    /** Push element x onto stack. */
    fun push(x: Int) {
        while (!data.isEmpty())
            temp.offer(data.poll())

        data.offer(x)

        while (!temp.isEmpty())
            data.offer(temp.poll())
    }

    /** Removes the element on top of the stack and returns that element. */
    fun pop(): Int {
        return data.poll()
    }

    /** Get the top element. */
    fun top(): Int {
        return data.peek()
    }

    /** Returns whether the stack is empty. */
    fun empty(): Boolean {
        return data.isEmpty()
    }

}

/**
 * Your MyStack object will be instantiated and called as such:
 * var obj = MyStack()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.empty()
 */

