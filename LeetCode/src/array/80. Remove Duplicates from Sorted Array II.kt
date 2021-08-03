package removeduplicatesfromsortedarray2

class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var offset = 0
        var count = 0
        var prev = Int.MIN_VALUE

        nums.forEachIndexed { index, num ->
            if (num != prev) {
                count = 1
                nums[index - offset] = num
                prev = num
            } else {
                count++
                if (count > 2)
                    offset++
                else
                    nums[index - offset] = num
            }
        }

        return nums.size - offset
    }
}

