package perfectsquares

import kotlin.math.min

class Solution {
    fun numSquares(n: Int): Int {
        val d = IntArray(n + 1)

        for (totalSquare in 1..n) {
            var length = 1
            var numberOfSquare = Int.MAX_VALUE
            while (length * length <= totalSquare) {
                numberOfSquare = min(numberOfSquare, d[totalSquare - length * length])
                length++
            }
            d[totalSquare] = numberOfSquare + 1
        }

        return d[n]
    }
}