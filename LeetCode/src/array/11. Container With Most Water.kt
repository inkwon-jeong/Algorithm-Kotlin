package containerwithmostwater

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun maxArea(height: IntArray): Int {
        var start = 0
        var end = height.lastIndex
        var maxArea = (end - start) * min(height[start], height[end])

        while (start < end) {
            if(height[start] < height[end])
                start++
            else
                end--

            maxArea = max(maxArea, (end - start) * min(height[start], height[end]))
        }

        return maxArea
    }
}

