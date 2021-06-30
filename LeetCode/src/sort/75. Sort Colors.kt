package sortcolors

class Solution {
    fun sortColors(nums: IntArray): Unit {
        val counts = IntArray(3)
        nums.forEach { counts[it]++ }

        var index = 0
        counts.forEachIndexed { num, count ->
            repeat(count) {
                nums[index++] = num
            }
        }
    }
}