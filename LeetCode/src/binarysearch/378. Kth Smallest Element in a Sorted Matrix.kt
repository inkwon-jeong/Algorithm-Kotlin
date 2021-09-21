package kthsmallestelementinasortedmatrix

import java.util.*

class Solution {
    fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
        val n = matrix.size
        val priorityQueue = PriorityQueue<Entry>()
        val visited = Array(n) { BooleanArray(n) }

        var count = 1
        priorityQueue.add(Entry(matrix[0][0], 0 to 0))
        visited[0][0] = true

        while (count < k) {
            count++

            val entry = priorityQueue.poll()
            val (x, y) = entry.coordinate

            if (x + 1 < n && !visited[x + 1][y]) {
                visited[x + 1][y] = true
                priorityQueue.add(Entry(matrix[x + 1][y], x + 1 to y))
            }

            if (y + 1 < n && !visited[x][y + 1]) {
                visited[x][y + 1] = true
                priorityQueue.add(Entry(matrix[x][y + 1], x to y + 1))
            }
        }
        return priorityQueue.poll().value
    }

    class Entry(
        val value: Int,
        val coordinate: Pair<Int, Int>
    ) : Comparable<Entry> {
        override fun compareTo(other: Entry): Int {
            return value - other.value
        }
    }
}