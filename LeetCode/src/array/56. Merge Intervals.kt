package mergeintervals

import kotlin.math.max

class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val sorted = intervals.sortedBy { (start, _) -> start }
        val answer = mutableListOf<IntArray>()

        var (start, end) = sorted[0]

        sorted.forEachIndexed { index, (nextStart, nextEnd) ->
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