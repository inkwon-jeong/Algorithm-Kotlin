package removeduplicatesfromsortedarray

class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var index = 0
        var num = Int.MIN_VALUE

        nums.forEach {
            if(num != it) {
                nums[index++] = it
                num = it
            }
        }

        return index
    }
}