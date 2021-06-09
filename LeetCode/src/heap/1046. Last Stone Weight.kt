package laststoneweight

import java.util.*

class Solution {

    fun lastStoneWeight(stones: IntArray): Int {
        val priorityQueue = PriorityQueue<Int>(Collections.reverseOrder())
        priorityQueue.addAll(stones.toList())

        while (priorityQueue.size > 1) {
            val stone1 = priorityQueue.poll()
            val stone2 = priorityQueue.poll()
            val remained = stone1 - stone2

            if (remained != 0)
                priorityQueue.add(remained)
        }

        return if(priorityQueue.isEmpty()) 0
        else priorityQueue.poll()
    }
}

