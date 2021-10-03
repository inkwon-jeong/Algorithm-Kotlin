package partitionequalsubsetsum

class Solution {

    fun canPartition(nums: IntArray): Boolean {
        if (nums.isEmpty()) {
            return true
        }

        var volumn = 0
        for (num in nums) {
            volumn += num
        }
        if (volumn % 2 != 0) {
            return false
        }
        volumn /= 2
        val dp = BooleanArray(volumn + 1)
        dp[0] = true

        for (i in 1..nums.size) {
            for (j in volumn downTo nums[i - 1]) {
                dp[j] = dp[j] || dp[j - nums[i - 1]]
            }
        }
        return dp[volumn]
    }
}