package exclusivetimeoffunctions

import java.util.*

class Solution {
    fun exclusiveTime(n: Int, logs: List<String>): IntArray {
        val res = IntArray(n)
        val stack = Stack<Int>()
        var prevTime = 0
        for (log in logs) {
            val parts = log.split(":".toRegex()).toTypedArray()
            if (!stack.isEmpty()) res[stack.peek()] += parts[2].toInt() - prevTime
            prevTime = parts[2].toInt()
            if (parts[1] == "start") stack.push(parts[0].toInt()) else {
                res[stack.pop()]++
                prevTime++
            }
        }
        return res
    }
}

