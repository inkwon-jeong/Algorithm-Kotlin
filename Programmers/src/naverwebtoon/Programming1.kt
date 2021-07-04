package programming1

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun solution(sizes: Array<IntArray>): Int {
        var maxWidth = 0
        var maxHeight = 0

        sizes.forEach { (a, b) ->
            val max = max(a, b)
            val min = min(a, b)

            if(maxWidth < max)
                maxWidth = max

            if(maxHeight < min)
                maxHeight = min
        }

        return maxWidth * maxHeight
    }
}