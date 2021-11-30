package maximumlengthofrepeatedsubarray

class Solution {
    fun findLength(nums1: IntArray, nums2: IntArray): Int {
        val m: Int = nums1.size
        val n: Int = nums2.size
        var max = 0

        val dp = Array(m + 1) { IntArray(n + 1) }
        for (i in 0..m) {
            for (j in 0..n) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0
                } else {
                    if (nums1[i - 1] == nums2[j - 1]) {
                        dp[i][j] = 1 + dp[i - 1][j - 1]
                        max = max.coerceAtLeast(dp[i][j])
                    }
                }
            }
        }
        return max
    }
}

