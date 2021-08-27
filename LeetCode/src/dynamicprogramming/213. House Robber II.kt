package houserubber2

import kotlin.math.max

class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1)
            return nums[0]

        val d1 = IntArray(nums.size)
        val d2 = IntArray(nums.size)

        d1[0] = nums[0]
        d1[1] = nums[0]
        d2[0] = 0
        d2[1] = nums[1]

        for (i in 2 until nums.size) {
            d1[i] = max(d1[i - 2] + nums[i], d1[i - 1])
            d2[i] = max(d2[i - 2] + nums[i], d2[i - 1])
        }

        return max(d1[nums.lastIndex - 1], d2[nums.lastIndex])
    }
}

