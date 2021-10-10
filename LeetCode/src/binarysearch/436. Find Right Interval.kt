package findrightinterval

class Solution {

    private val indexMap = mutableMapOf<Int, Int>()

    fun findRightInterval(intervals: Array<IntArray>): IntArray {
        intervals.forEachIndexed { index, (a, _) ->
            indexMap[a] = index
        }

        val sorted = intervals.sortedBy { (a, _) -> a }
        val answer = IntArray(intervals.size)
        sorted.forEach { (a, b) ->
            val index = indexMap[a]!!
            answer[index] = binarySearch(sorted, b)
        }
        return answer
    }

    private fun binarySearch(sorted: List<IntArray>, target: Int): Int {
        var start = 0
        var end = sorted.lastIndex

        while (start <= end) {
            val mid = (start + end) / 2
            val value = sorted[mid].first()
            when {
                target == value -> return indexMap[sorted[mid].first()]!!
                target > value -> start = mid + 1
                else -> end = mid - 1
            }
        }

        return if (start > sorted.lastIndex) -1 else indexMap[sorted[start].first()]!!
    }
}