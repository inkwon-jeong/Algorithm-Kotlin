package removeelement

class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var count = 0
        nums.forEachIndexed { index, num ->
            if(num == `val`) {
                count++
            } else {
                nums[index - count] = num
            }
        }

        return nums.size - count
    }
}