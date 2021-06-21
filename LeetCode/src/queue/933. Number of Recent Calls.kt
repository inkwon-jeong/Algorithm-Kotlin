package numverofrecentcalls

import java.util.*

class RecentCounter() {

    private val queue: Queue<Int> = LinkedList()

    fun ping(t: Int): Int {
        while (queue.isNotEmpty() && queue.peek() + 3000 < t) {
            queue.poll()
        }

        queue.add(t)
        return queue.size
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * var obj = RecentCounter()
 * var param_1 = obj.ping(t)
 */

