package jumpgame

class Solution {
    fun canJump(nums: IntArray): Boolean {
        var maxIndex = 0

        nums.forEachIndexed { index, num ->
            if(maxIndex < index) return false
            if(maxIndex >= nums.lastIndex) return true
            maxIndex = maxOf(index + num, maxIndex)
        }

        return true
    }
}

