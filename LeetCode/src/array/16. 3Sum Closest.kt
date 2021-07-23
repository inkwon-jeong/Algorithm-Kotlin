package threesumclosest

import kotlin.math.absoluteValue

class Solution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()
        var diff = Int.MAX_VALUE

        for(i in nums.indices) {
            var start = i + 1
            var end = nums.lastIndex
            while (start < end) {
                val sum = nums[i] + nums[start] + nums[end]
                if(diff.absoluteValue > (target - sum).absoluteValue)
                    diff = target - sum

                when {
                    sum > target -> end--
                    sum < target -> start++
                    else -> return target
                }
            }
        }

        return target - diff
    }
}

