package searchinsertposition

class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var startIndex = 0
        var endIndex = nums.lastIndex

        if(nums[startIndex] > target) return 0
        if(nums[endIndex] < target) return endIndex + 1

        while (startIndex <= endIndex) {
            val index = (startIndex + endIndex) / 2
            val num = nums[index]

            when {
                num == target -> return index
                num < target -> startIndex = index + 1
                else -> endIndex = index - 1
            }
        }

        return startIndex
    }
}

