package longestincreasingsubsequence

class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val sequence = IntArray(nums.size)
        var size = 0

        for (num in nums) {
            var start = 0
            var end = size
            while (start < end) {
                val mid = (start + end) / 2
                when {
                    num > sequence[mid] -> start = mid + 1
                    else -> end = mid
                }
            }
            sequence[start] = num
            if (start == size) size++
        }

        return size
    }
}

