package totalhammingdistance

class Solution {
    fun totalHammingDistance(nums: IntArray): Int {
        var total = 0
        val n: Int = nums.size
        for (j in 0..31) {
            var bitCount = 0
            for (i in 0 until n) bitCount += nums[i] shr j and 1
            total += bitCount * (n - bitCount)
        }
        return total
    }
}

