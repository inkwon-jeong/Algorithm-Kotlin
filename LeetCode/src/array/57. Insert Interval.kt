package insertinterval

import kotlin.math.max

class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val added = intervals.plus(newInterval)
        val sorted = added.sortedBy { (start, _) -> start }
        val answer = mutableListOf<IntArray>()

        var (start, end) = sorted[0]

        sorted.forEach { (nextStart, nextEnd) ->
            if(end >= nextStart) {
                end = max(end, nextEnd)
            } else {
                answer.add(intArrayOf(start, end))
                start = nextStart
                end = nextEnd
            }
        }

        answer.add(intArrayOf(start, end))

        return answer.toTypedArray()
    }
}

