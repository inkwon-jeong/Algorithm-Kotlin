package longestpalindromicsubsequence

class Solution {
    fun longestPalindromeSubseq(s: String): Int {
        val dp = Array(s.length) { IntArray(s.length) }

        for (i in s.length - 1 downTo 0) {
            dp[i][i] = 1
            for (j in i + 1 until s.length) {
                if (s[i] == s[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2
                } else {
                    dp[i][j] = dp[i + 1][j].coerceAtLeast(dp[i][j - 1])
                }
            }
        }
        return dp[0][s.length - 1]
    }
}

