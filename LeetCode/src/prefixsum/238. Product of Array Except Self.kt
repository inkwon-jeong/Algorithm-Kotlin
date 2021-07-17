package productofarrayexceptself

class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val answer = IntArray(nums.size) { 1 }
        for(i in 1..nums.lastIndex) {
            answer[i] = nums[i - 1] * answer[i - 1]
        }

        for(i in nums.lastIndex - 1 downTo 0) {
            nums[i] = nums[i] * nums[i + 1]
        }

        for(i in 0 until nums.lastIndex) {
            answer[i] = answer[i] * nums[i + 1]
        }

        return answer
    }
}

