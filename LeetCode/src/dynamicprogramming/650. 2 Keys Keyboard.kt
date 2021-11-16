package twokeyskeyboard

class Solution {
    fun minSteps(n: Int): Int {
        val dp = IntArray(n + 1)

        for (i in 2..n) {
            dp[i] = i
            for (j in i - 1 downTo 2) {
                if (i % j == 0) {
                    dp[i] = dp[j] + i / j
                    break
                }
            }
        }
        return dp[n]
    }
}

