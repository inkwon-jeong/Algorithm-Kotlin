package movingstonesuntilconsecutive

import kotlin.math.max

class Solution {
    fun numMovesStones(a: Int, b: Int, c: Int): IntArray {
        val (start, mid, end) = intArrayOf(a, b, c).sortedArray()

        val diff1 = (mid - start) - 1
        val diff2 = (end - mid) - 1

        val min = when {
            diff1 == 0 && diff2 == 0 -> 0
            diff1 <= 1 || diff2 <= 1 -> 1
            else -> 2
        }
        val max = max(diff1 + diff2, 0)
        return intArrayOf(min, max)
    }
}

