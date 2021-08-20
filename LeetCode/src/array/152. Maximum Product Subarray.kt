package maximumproductsubarray

import kotlin.math.max

class Solution {
    fun maxProduct(nums: IntArray): Int {
        var answer = nums[0]
        var left = 0
        var right = 0
        for (i in nums.indices) {
            left = (if (left == 0) 1 else left) * nums[i]
            right = (if (right == 0) 1 else right) * nums[nums.lastIndex - i]
            answer = max(answer, max(left, right))
        }

        return answer
    }
}

