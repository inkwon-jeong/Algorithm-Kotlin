package minimumtimedifference

class Solution {
    fun findMinDifference(timePoints: List<String>): Int {
        val mark = BooleanArray(24 * 60)
        for (time in timePoints) {
            val t = time.split(":".toRegex()).toTypedArray()
            val h = t[0].toInt()
            val m = t[1].toInt()
            if (mark[h * 60 + m]) return 0
            mark[h * 60 + m] = true
        }

        var prev = 0
        var min = Int.MAX_VALUE
        var first = Int.MAX_VALUE
        var last = Int.MIN_VALUE
        for (i in 0 until 24 * 60) {
            if (mark[i]) {
                if (first != Int.MAX_VALUE) {
                    min = min.coerceAtMost(i - prev)
                }
                first = first.coerceAtMost(i)
                last = last.coerceAtLeast(i)
                prev = i
            }
        }

        min = min.coerceAtMost(24 * 60 - last + first)

        return min
    }
}

