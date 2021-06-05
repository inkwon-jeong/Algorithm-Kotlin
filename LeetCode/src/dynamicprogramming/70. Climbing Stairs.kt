package climbingstairs

class Solution {
    fun climbStairs(n: Int): Int {
        val d = IntArray(n + 1)
        d[0] = 1
        d[1] = 1

        for (i in 2..n) {
            d[i] = d[i - 2] + d[i - 1]
        }

        return d[n]
    }
}

