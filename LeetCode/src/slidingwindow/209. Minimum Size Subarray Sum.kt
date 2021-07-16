package minimumsizesubarraysum

import kotlin.math.min

class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var start = 0
        var end = 0

        var sum = nums[start]
        var answer = Int.MAX_VALUE
        while (end < nums.size) {
            when {
                sum >= target -> {
                    answer = min(answer, (end - start + 1))
                    sum -= nums[start++]

                    if (start > end) {
                        end++
                        if(end < nums.size)
                            sum += nums[end]
                    }
                }
                sum < target -> {
                    end++
                    if(end < nums.size)
                        sum += nums[end]
                }
            }
        }

        return if (answer == Int.MAX_VALUE) 0
        else answer
    }
}

