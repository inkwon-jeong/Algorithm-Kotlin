package decodestring

import java.util.*

class Solution {
    fun decodeString(s: String): String {
        val queue: Deque<Char> = LinkedList()
        for (c in s.toCharArray()) queue.offer(c)
        return decodeString(queue)
    }

    private fun decodeString(queue: Deque<Char>): String {
        val sb = StringBuilder()
        var num = 0
        while (!queue.isEmpty()) {
            val c = queue.poll()
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0')
            } else if (c == '[') {
                val sub = decodeString(queue)
                for (i in 0 until num) sb.append(sub)
                num = 0
            } else if (c == ']') {
                break
            } else {
                sb.append(c)
            }
        }
        return sb.toString()
    }
}

