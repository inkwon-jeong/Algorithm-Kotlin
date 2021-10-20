package nextgreaterelement2

import java.util.*

class Solution {
    fun nextGreaterElements(nums: IntArray): IntArray {
        val n = nums.size
        val res = IntArray(n)
        Arrays.fill(res, -1)
        val stack = Stack<Int>()
        for (i in 0 until n * 2) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n])
                res[stack.pop()] = nums[i % n]
            stack.push(i % n)
        }
        return res
    }
}

