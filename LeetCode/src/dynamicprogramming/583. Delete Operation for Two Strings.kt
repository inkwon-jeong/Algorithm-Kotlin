package deleteoperationfortwostrings

import kotlin.math.max

class Solution {
    fun minDistance(word1: String, word2: String): Int {
        val dp = Array(word1.length + 1) { IntArray(word2.length + 1) }
        for (i in 0..word1.length) {
            for (j in 0..word2.length) {
                if (i == 0 || j == 0) dp[i][j] = 0 else dp[i][j] =
                    if (word1[i - 1] == word2[j - 1]) dp[i - 1][j - 1] + 1
                    else max(dp[i - 1][j], dp[i][j - 1])
            }
        }
        val `val` = dp[word1.length][word2.length]
        return word1.length - `val` + word2.length - `val`
    }
}

