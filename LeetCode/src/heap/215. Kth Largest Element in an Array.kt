package kthlargestelementinanarray

import java.util.*

class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val priorityQueue = PriorityQueue<Int>(Collections.reverseOrder())
        nums.forEach { num ->
            priorityQueue.add(num)
        }

        var answer = 0
        repeat(k) { answer = priorityQueue.poll() }

        return answer
    }
}

